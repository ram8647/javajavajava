// Custom js file
// Change text of buttons
var prevbtn = document.querySelector('.previous-button');
var nextbtn = document.querySelector('.next-button');
var upbtn = document.querySelector('.up-button');
prevbtn.style.content = 'none'; // clear ::after that pretext adds - but didn't work
prevbtn.textContent = '<';
nextbtn.style.content = 'none';
nextbtn.textContent = '>';
upbtn.style.content = 'none';
upbtn.textContent = '^';

document.onreadystatechange = function () {
    if (document.readyState == "complete") 
       if (typeof toggletoc !== undefined) 
          toggletoc();  // pretext v. 0.2, on Runestone   
       else if (window.mathbook != null)
          window.mathbook.toggleSidebarLeft(false); // pretext v. 0.13, in local versi
}




