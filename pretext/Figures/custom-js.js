// Custom js file
// Change text of buttons
let previousButton = document.querySelector('#previousbutton');
let nextButton = document.querySelector('#nextbutton');
let upButton = document.querySelector('#upbutton');
previousButton.style.content = 'none'; // clear ::after that pretext adds - but didn't work
previousButton.textContent = '<';
nextButton.style.content = 'none';
nextButton.textContent = '>';
upButton.style.content = 'none';
upButton.textContent = '^';


// works locally in pretext.js version 13
document.onreadystatechange = function () {
    if (document.readyState == "complete") 
       window.mathbook.toggleSidebarLeft(false);
}



// or this toggles side nav closed in Runestone version but not local, pretext.js version 3
toggletoc(); 



