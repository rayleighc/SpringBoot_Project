//Doing a Product web app, in product page to 
//display the name, description, imageUrl, style, price, ..., ...,.....,....


const createHTMLList = (index, title, description, target_date) =>
`
<div class="col-lg-4">
<div class="card" style="width: 18rem;">

    <div class="card-body">

        <h5 class="card-title">${title}</h5>
        <p class="card-text">${description}</p>
         <p class="card-text">${target_date}</p>

    </div>
</div>
</div>

`;



class ProductsController 
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the array
    addItem(title, description, target_date)
    {
        //POST HTTP Method
                var productController = this;

const item = {
title:title,
description:description,
target_date:target_date
};

                const formData = new FormData();
                //key/value pair
                //key (e.g. 'name') needs to match with the @RequestParam from the postmapping in your ItemController.java Class
                //value is the parameter that is passed from the productForm.js (e.g. New T-Shirt

                formData.append('title', title);
                formData.append('description', description);
                formData.append('target_date', target_date);


                fetch('http://localhost:8080/item/add', {
                     method: 'POST',
                     body: formData
                     })
                     .then(response => response.json())
                     .then(data => {
                         console.log('Success:', data);
                         alert("Successfully added to TODO List")
                     })
                     .catch((error) => {
                         console.error('Error:', error);
                         alert("Error adding item to TODO List")
                     });
    }

    displayItem()
    {
        var productController = this;
            productController._items = [];

        //fetch data from database using the REST API endpoint from Spring Boot
        fetch('http://127.0.0.1:8080/item/all')
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);
                data.forEach(function (item, index) {

                    const itemObj = {
                        id: item.id,
                        title: item.title,
                        description: item.description,
                        target_date: item.target_date,

                    };
                    productController._items.push(itemObj);
                });

                productController.renderProductPage();

            })
            .catch(function(error) {
                console.log(error);
            });
    }


    renderProductPage()
    {
        var productHTMLList = [];
        
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.title, item.description, item.target_date);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and separate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#row').innerHTML = pHTML;


        //addEventListener - click 
        for (var i=0; i<this._items.length; i++)
        {
            const item = this._items[i];
            document.getElementById(i).addEventListener("click", function() { displayProductDetails(item);} );
        }

    }


}   //End of ProductsController class
