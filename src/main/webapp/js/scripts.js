/**
 * 
 */
"use strict";
const btnAddtask = document.querySelector(".add--item");
const mainModal = document.querySelector(".main-modal");
const addItemModal = document.querySelector(".additem-modal");
const overlay = document.querySelector(".overlay");

//scripts
btnAddtask.addEventListener("click",function(){
	overlay.classList.remove("hidden");
	addItemModal.classList.remove("hidden");
});

overlay.addEventListener("click",function(){
	overlay.classList.add("hidden");
	addItemModal.classList.add("hidden");
})
 
 