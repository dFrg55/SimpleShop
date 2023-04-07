jQuery($ => {

    // Обрабатываем нажатие кнопки «Просмотр товара»
    $(document).on("click", ".read-one-product-button", function () {

        const id = $(this).attr("data-id");
        let url="api/item/getOneItem/";
        fetch(url+id).then(function(response) {
            response.json().then(function(data) {
                // Начало HTML
                let read_one_product_html = `
        
                    <!-- При нажатии будем отображать список товаров -->
                    <div id="read-products" class="btn btn-primary pull-right m-b-15px read-products-button">
                        <span class="glyphicon glyphicon-list"></span> Все товары
                    </div>
                    <!-- Полные данные о товаре будут показаны в этой таблице -->
                    <table class="table table-bordered table-hover">
                    
                        <tr>
                            <td class="w-30-pct">Название</td>
                            <td class="w-70-pct">` + data.name + `</td>
                        </tr>
                    
                        <tr>
                            <td>Цена</td>
                            <td>` + data.price + `</td>
                        </tr>
                    
                        <tr>
                            <td>Описание</td>
                            <td>` + data.description + `</td>
                        </tr>
                    
                    </table>`;
                // Вставка HTML в «page-content» нашего приложения
                $("#page-content").html(read_one_product_html);

                // Изменяем заголовок страницы
                changePageTitle("Просмотр товара");
            });
        });
    });

});