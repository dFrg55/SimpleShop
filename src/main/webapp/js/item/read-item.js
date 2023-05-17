jQuery(($) => {

    // Показать список товаров при первой загрузке
    showProducts();
    $(document).on("click", ".read-products-button", () => {
        showProducts();
    });
});
function showProducts() {
    const url="api/item/getAllItem";

    fetch(url).then(function(response) {
        response.json().then(function(data) {
            let read_products_html = `
                <!-- При нажатии загружается форма создания товара -->
                <div id="create-product" class="btn btn-primary pull-right m-b-15px create-product-button">
                    <span class="glyphicon glyphicon-plus"></span> Создание товара
                </div>
                <div  id="shopping-cart" class="btn btn-primary pull-right m-b-15px log-out">
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
            for (let key in data){
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
                            <!-- Кнопка редактирования -->
                            <button class="btn btn-info m-r-10px update-product-button" data-id="` + data[key].id + `">
                                <span class="glyphicon glyphicon-edit"></span> Редактирование
                            </button>
                            <!-- Кнопка удаления товара -->
                            <button class="btn btn-danger delete-product-button" data-id="` + data[key].id + `">
                                <span class="glyphicon glyphicon-remove"></span> Удаление
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