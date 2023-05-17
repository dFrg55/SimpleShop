    jQuery(($) => {
    setCookie('token','1',7);
        // HTML приложения
        let app_html = `
            <div class="container">
                <div class="page-header">
                    <h1 id="page-title">Все товары</h1>
                </div>
    
                <!-- Здесь будет показано содержимое страницы -->
                <div id="page-content"></div>
            </div>`;
        // Вставка кода на страницу
        $("#app").html(app_html);
    });

    // Изменение заголовка страницы
    function changePageTitle(page_title) {

        // Изменение заголовка страницы
        $("#page-title").text(page_title);

        // Изменение заголовка вкладки браузера
        document.title = page_title;
    }
    function log(page_title) {

    }
    // Функция для создания значений формы в формате json
    $.fn.serializeObject = function () {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || "");
            } else {
                o[this.name] = this.value || "";
            }
        });
        return o;
    };
    //Logout
    jQuery(($) => {

        // Показать html форму при нажатии кнопки «создать товар»
        $(document).on("click", ".log-out", function () {

            const url="/logout";

            try {
                const response = fetch(url, {
                    method: 'GET', // или 'PUT'
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });
                console.log('Успех:');
            } catch (error) {
                console.error('Ошибка:', error);
            }

            let homePageUrl = "/home"

            setTimeout(function(){
                window.location.href = homePageUrl
            }, 100);
        });
    });

function setCookie(name,value,days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}
function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}
function eraseCookie(name) {
    document.cookie = name +'=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

