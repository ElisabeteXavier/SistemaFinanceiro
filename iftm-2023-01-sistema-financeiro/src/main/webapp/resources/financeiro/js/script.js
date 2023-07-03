//toogle menu
function toggleMenu() {
    if(isMobile()) {
        document.querySelector(".menu").classList.toggle("menu-show");
        document.querySelector(".overlay-menu").classList.toggle("overlay-menu-show");
    } else {
        document.querySelector(".menu").classList.toggle("collapse-menu");
        document.querySelector("header").classList.toggle("collapse-menu");
        document.querySelector("main").classList.toggle("collapse-menu");
        document.querySelector("footer").classList.toggle("collapse-menu");
    }
}
//Check if mobile device
function isMobile() {
    return window.innerWidth <= 768;
}
document.querySelector(".btn-toogle-menu").addEventListener("click", toggleMenu);
document.querySelector(".overlay-menu").addEventListener("click", toggleMenu);