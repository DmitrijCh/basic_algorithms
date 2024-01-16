# Стек - Max

Нужно реализовать класс StackMax, который поддерживает операцию определения максимума среди всех элементов в стеке. 
Класс должен поддерживать операции push(x), где x – целое число, pop() и get_max().

## Формат ввода

В первой строке записано одно число n — количество команд, которое не превосходит 10000. В следующих n строках идут команды.
Команды могут быть следующих видов:

- push(x) — добавить число x в стек;
- pop() — удалить число с вершины стека;
- get_max() — напечатать максимальное число в стеке;

Если стек пуст, при вызове команды get_max() нужно напечатать «None», для команды pop() — «error».

## Формат вывода

Для каждой команды get_max() напечатайте результат её выполнения. Если стек пустой, для команды get_max() напечатайте «None».
Если происходит удаление из пустого стека — напечатайте «error».

### Пример 1

| Ввод                                                                                     | Вывод               |
|------------------------------------------------------------------------------------------|---------------------|
| 8<br/>get_max<br/>push 7<br/>pop<br/>push -2<br/>push -1<br/>pop<br/>get_max<br/>get_max | None<br/>-2<br/>-2  |

### Пример 2

| Ввод                                                                       | Вывод                                     |
|----------------------------------------------------------------------------|-------------------------------------------|
| 7<br/>get_max<br/>pop<br/>pop<br/>pop<br/>push 10<br/>get_max<br/>push -9  | None<br/>error<br/>error<br/>error<br/>10 |