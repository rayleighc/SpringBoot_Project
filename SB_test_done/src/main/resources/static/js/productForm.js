//Create an instance object of ProductsController
const productsControl = new ProductsController();


//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newTitle = document.querySelector('#newTitle');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newTarget_date = document.querySelector('#newTarget_date');




    // Get the values of the inputs - variable names to be same as MySQL columns
    const title = newTitle.value;   //input value from user
    const description = newItemDescription.value;
    const target_date = newTarget_date.value;

    // Add the task to the task manager
        productsControl.addItem(title, description, target_date);

    // Clear the form
    newTitle.value = '';
    newItemDescription.value = '';
    newTarget_date.value = '';



});



