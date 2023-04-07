jQuery($ => {

    // Будет работать, если была нажата кнопка удаления
    $(document).on("click", ".delete-product-button", function () {

        // Получение ID товара
        const product_id = $(this).attr("data-id");
        const url="api/item/deleteItem/";
        // Bootbox для подтверждения во всплывающем окне
        bootbox.confirm({
            message: "<h4>Вы уверены?</h4>",
            buttons: {
                confirm: {
                    label: "<span class='glyphicon glyphicon-ok'></span> Да",
                    className: "btn-danger"
                },
                cancel: {
                    label: "<span class='glyphicon glyphicon-remove'></span> Нет",
                    className: "btn-primary"
                }
            },
            callback: result => {

                if (result == true) {
                    const response = fetch(url+product_id , {
                        method: 'DELETE',
                        body: JSON.stringify({ id: product_id }),
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


                }
            }
        });
    });
});