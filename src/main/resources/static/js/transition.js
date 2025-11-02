document.addEventListener('DOMContentLoaded', () => {
    const body = document.querySelector('.transition-body');
    // Select all links (a tags) in the document
    const links = document.querySelectorAll('a[href]');

    // 1. FADE IN on load
    // Add the 'loaded' class after a brief moment to trigger the CSS transition
    setTimeout(() => {
        if (body) {
            body.classList.add('loaded');
        }
    }, 10);

    // 2. FADE OUT on link click
    links.forEach(link => {
        // Intercept link clicks to enable a smooth transition between pages
        link.addEventListener('click', (event) => {
            const newLocation = link.href;

            // Check if it's an internal link to prevent issues with external URLs
            if (link.hostname === window.location.hostname && body) {

                // Stop default navigation
                event.preventDefault();

                // Start the fade-out (opacity 1 -> 0)
                body.classList.remove('loaded');

                // Wait for the CSS transition (0.5 seconds) to complete, then navigate
                setTimeout(() => {
                    window.location = newLocation;
                }, 500);
            }
            // If it's an external link or no body class, allow default navigation
        });
    });
});
