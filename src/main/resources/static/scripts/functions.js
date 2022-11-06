function hideShow(parent, sibling1, sibling2) {
    const parents = document.getElementsByClassName(parent);

    for (parent of parents) {
        const child1 = parent.querySelector(sibling1);
        const child2 = parent.querySelector(sibling2);

        child1.addEventListener("click", function() {
            if (this.show)   {
                this.show = false;
                this.nextElementSibling.style.display = "none";
            } else {
                this.show = true;
                this.nextElementSibling.style.display = "flex";
            }
        });
        child1.show = false;

        child2.style.display = "none";
    }
}

function removeLastBorder(className) {
    const classes = document.getElementsByClassName(className);
    
    // remove the border of the last item
    classes[classes.length - 1].style.border = "none";
}
