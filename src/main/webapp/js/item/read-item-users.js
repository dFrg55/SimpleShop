var elementsShoppingCart=[];
jQuery(($) => {

    // Показать список товаров при первой загрузке
    showProducts();
    $(document).on("click", ".read-products-button", () => {
        showProducts();
    });

    $(document).on("click", ".shopping-cart-button", () => {
        showShoppingCart();
    });
    $(document).on("click", ".addToShoppingCart-product-button", function () {

        // Получение ID товара
        const product_id = $(this).attr("data-id");
        console.log(product_id)
        let url="api/item/getOneItem/";
        addElemetInShoppingCart(product_id)
    });
    $(document).on("click", ".deleteProductButtonFromShoppingCart", function () {
        // Получение ID товара
        const product_id = $(this).attr("data-id");
        elementsShoppingCart=elementsShoppingCart.filter((n) => {return n.id != product_id})
        showShoppingCart();
    });
});

function showProducts() {
    const url = "api/item/getAllItem";

    fetch(url).then(function (response) {
        response.json().then(function (data) {
            let read_products_html = `
                <div  id="shopping-cart" class="btn btn-primary pull-right m-b-15px shopping-cart-button">
                    <span class="glyphicon glyphicon-plus""></span> Корзина
                </div>
                <div  id="log-out" class="btn btn-primary pull-right m-b-15px log-out">
                    <span class="glyphicon glyphicon-plus""></span> Выход
                </div>
                <!-- Таблица товаров -->
                <table class="table table-bordered table-hover">
            
                <!-- Создание заголовков таблицы -->
                <tr>
                    <th class="w-15-pct">Название</th>
                    <th class="w-10-pct">Цена</th>
                    <th class="w-25-pct text-align-center">Действие</th>
                </tr>`;

            // Перебор списка возвращаемых данных
            for (let key in data) {
                // Создание новой строки таблицы для каждой записи
                read_products_html += `
                    <tr>
                        <td>` + data[key].name + `</td>
                        <td>` + data[key].price + `</td>
                
                        <!-- Кнопки "действий" -->
                        <td>
                            <!-- Кнопка чтения товара -->
                            <button class="btn btn-primary m-r-10px read-one-product-button" data-id="` + data[key].id + `">
                                <span class="glyphicon glyphicon-eye-open"></span> Просмотр
                            </button>
                            <!-- Кнопка добавление в корзину товара -->
                            <button class="btn btn-info m-r-10px addToShoppingCart-product-button" data-id="` + data[key].id + `">
                                <span class="glyphicon glyphicon-edit"></span> Добавить в корзину
                            </button>
                        </td>
                    </tr>`;
            };

            read_products_html += `</table>`;
            $("#page-content").html(read_products_html);
            changePageTitle("Все товары");

        });
    });
}

function showShoppingCart() {
    let data=elementsShoppingCart
    let shopping_cart_html = `
                <div  id="read-products" class="btn btn-primary pull-right m-b-15px read-products-button">
                    <span class="glyphicon glyphicon-list"></span> Все товары
                </div>
                <div  id="log-out" class="btn btn-primary pull-right m-b-15px log-out">
                    <span class="glyphicon glyphicon-plus""></span> Выход
                </div>
                <!-- Таблица товаров -->
                <table class="table table-bordered table-hover">
            
                <!-- Создание заголовков таблицы -->
                <tr>
                    <th class="w-15-pct">Название</th>
                    <th class="w-10-pct">Цена</th>
                    <th class="w-25-pct text-align-center">Действие</th>
                </tr>`;

    // Перебор списка возвращаемых данных
    for (let key in data) {
        // Создание новой строки таблицы для каждой записи
        shopping_cart_html += `
                    <tr>
                        <td>` + data[key].name + `</td>
                        <td>` + data[key].price + `</td>
                
                        <!-- Кнопки "действий" -->
                        <td>
                            <!-- Кнопка чтения товара -->
                            <button class="btn btn-primary m-r-10px read-one-product-button" data-id="` + data[key].id + `">
                                <span class="glyphicon glyphicon-eye-open"></span> Просмотр
                            </button>
                            <!-- Кнопка удаления товара -->
                            <button class="btn btn-danger deleteProductButtonFromShoppingCart" data-id="` + data[key].id + `">
                                <span class="glyphicon glyphicon-remove"></span> Удаление
                            </button>
                        </td>
                    </tr>   `;
    };

    shopping_cart_html += `</table>`;
    $("#page-content").html(shopping_cart_html);
    changePageTitle("Корзина");
}
function addElemetInShoppingCart(id){
    let url="api/item/getOneItem/";
    fetch(url+id).then(function(response) {
        response.json().then(function(data) {
            console.log(JSON.stringify(data))
            elementsShoppingCart.push(data);
            console.log(JSON.stringify(elementsShoppingCart))
        });
    });
}
