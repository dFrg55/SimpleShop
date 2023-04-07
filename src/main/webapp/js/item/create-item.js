jQuery(($) => {

    // Показать html форму при нажатии кнопки «создать товар»
    $(document).on("click", ".create-product-button", () => {


        let create_product_html=`
            <!-- Кнопка для показа всех товаров -->
            <div id="read-products" class="btn btn-primary pull-right m-b-15px read-products-button">
                <span class="glyphicon glyphicon-list"></span> Все товары
            </div>
            <!-- html форма «Создание товара» -->
            <form id="create-product-form" action="#" method="post" border="0">
                <table class="table table-hover table-responsive table-bordered">
            
                    <tr>
                        <td>Название</td>
                        <td><input type="text" name="name" class="form-control" required /></td>
                    </tr>
            
                    <tr>
                        <td>Цена</td>
                        <td><input type="number" min="1" name="price" class="form-control" required /></td>
                    </tr>
                    <tr>
                        <td>Описание</td>
                        <td><textarea name="description" class="form-control" required></textarea></td>
                    </tr>
            
                    <!-- Кнопка отправки формы -->
                    <tr>
                        <td></td>
                        <td>
                            <button type="submit" class="btn btn-primary">
                                <span class="glyphicon glyphicon-plus"></span> Создать товар
                            </button>
                        </td>
                    </tr>
            
                </table>
            </form>
        `;

        // Вставка html в «page-content» нашего приложения
        $("#page-content").html(create_product_html);
        // Изменяем тайтл
        changePageTitle("Создание товара");
    });
    $(document).on("submit", "#create-product-form", function () {

        // Получение данных формы
        let form_data=JSON.stringify($(this).serializeObject());


        const url="api/item/saveItem";

        try {
            const response = fetch(url, {
                method: 'POST', // или 'PUT'
                body: form_data, // данные могут быть 'строкой' или {объектом}!
                headers: {
                    'Content-Type': 'application/json'
                }
            });
            console.log('Успех:');
        } catch (error) {
            console.error('Ошибка:', error);
        }
        return false;
    });
});

