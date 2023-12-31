
**Тестовое задание.**
=
    
Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Пример входной строки:  

    “aaaaabcccc”

Пример выходного результата:    

    “a”: 5, “c”: 4, “b”: 1

Требования к решению:

    Java 8+
    Spring boot 2+
    Решение должно быть покрыто тестами
    У решения должна быть документация по запуску и формату входящих/исходящих параметров
    Код решения необходимо разместить в публичном Github репозитории.


**Запуск программы**
=

Проект запускается с помощью команды:

    docker compose -f docker-compose.dev.yml up --build

После этого в браузере при переходе на url <http://localhost:8090/api/?string=aaaabbbb> вы увидите пример работы программы.

**Описание работы программы**
=

Формат входящих данных - строка(длина строки не 0 и не больше 100 символов)

В программе реализован REST контроллер который принимает строку в url-запросе:
    
    http://localhost:8090/api/?string=xxxxxxxxxx

считает сколько раз встречается каждый символ в строке и возвращает результат в формате json:
    
    {"a":3,"b":3,"c":3} - например

Если исходная строка пустая, на экране будет выведено соотвествующее сообщение:

    {"error":"Bad Request","error_description":"string can't be null"}

Если длина строки больше 100 символов будет выведено другое сообщение:

    {"error":"Bad Request","error_description":"string size can't be higher than 100"}