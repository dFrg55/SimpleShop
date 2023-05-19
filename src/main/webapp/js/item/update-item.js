jQuery($ => {

    // Показывать HTML форму при нажатии кнопки «Обновить товар»
    $(document).on("click", ".update-product-button", function () {

        // Получаем ID товара
        const id = $(this).attr("data-id");
        const url="api/item/getOneItem/";

        // Читаем одну запись на основе данного идентификатора товара
        fetch(url+id).then(function(response) {
            response.json().then(function(data) {
                // Значения будут использоваться для заполнения нашей формы
                const name = data.name;
                const price = data.price;
                const description = data.description;
                const category_id = data.category_id;
                const category_name = data.category_name;


                // Сохраним html в переменной «update product»
                let update_product_html = `
                    <div id="read-products" class="btn btn-primary pull-right m-b-15px read-products-button">
                        <span class="glyphicon glyphicon-list"></span> Все товары
                    </div>
                
                    <!-- Построение формы для изменения товара -->
                    <!-- Мы используем свойство "required" html5 для предотвращения пустых полей -->
                    <form id="update-product-form" action="#" method="post" border="0">
                        <table class="table table-hover table-responsive table-bordered">
                
                            <tr>
                                <td>Название</td>
                                <td><input value=\"` + name + `\" type="text" name="name" class="form-control" required /></td>
                            </tr>
                
                            <tr>
                                <td>Цена</td>
                                <td><input value=\"` + price + `\" type="number" min="1" name="price" class="form-control" required /></td>
                            </tr>
                
                            <tr>
                                <td>Описание</td>
                                <td><textarea name="description" class="form-control" required>` + description + `</textarea></td>
                            </tr>
                
                            <tr>
                                <!-- Скрытый «идентификатор товара, чтобы определить, какую запись удалить -->
                                <td><input value=\"` + id + `\" name="id" type="hidden" /></td>
                
                                <!-- Кнопка отправки формы -->
                                <td>
                                    <button type="submit" class="btn btn-info">
                                        <span class="glyphicon glyphicon-edit"></span> Обновить товар
                                    </button>
                                </td>
                            </tr>
                
                        </table>
                    </form>
                `;

                // Добавим в «page-content» нашего приложения
                $("#page-content").html(update_product_html);
                // Изменим title страницы
                changePageTitle("Обновление товара");
            });
        });
    });

    // Будет запущен при отправке формы обновления товара
    $(document).on("submit", "#update-product-form", function() {

        // Получение данных формы
        let form_data=JSON.stringify($(this).serializeObject());


        const url="api/item/secure/saveItem";

        const response = fetch(url, {
            method: 'POST', // или 'PUT'
            body: form_data, // данные могут быть 'строкой' или {объектом}!

            headers: {
                'Content-Type': 'application/json'
            }
        }).then((response)=>{
            if(response.ok){
                showProducts();
            }
        })
        .catch((error) => {
            console.error("There has been a problem with your fetch operation:", error);
        });

        return false;
    });
});