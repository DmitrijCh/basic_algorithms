# Ближайший ноль

Улица, на которой хочет жить Тимофей, имеет длину n, то есть состоит из n одинаковых идущих подряд участков.
На каждом участке либо уже построен дом, либо участок пустой. Тимофей ищет место для строительства своего дома.
Он очень общителен и не хочет жить далеко от других людей, живущих на этой улице.

Чтобы оптимально выбрать место для строительства, Тимофей хочет для каждого участка знать расстояние до ближайшего пустого участка.
(Для пустого участка эта величина будет равна нулю –— расстояние до самого себя).

Ваша задача –— помочь Тимофею посчитать искомые расстояния. Для этого у вас есть карта улицы. 
Дома в городе Тимофея нумеровались в том порядке, в котором строились, поэтому их номера на карте никак не упорядочены. 
Пустые участки обозначены нулями.

## Формат ввода

В первой строке дана длина улицы —– n (1 ≤ n ≤ 10<sup>6</sup>). В следующей строке записаны n целых неотрицательных чисел —
номера домов и обозначения пустых участков на карте (нули). Гарантируется, что в последовательности есть хотя бы один ноль. 
Номера домов (положительные числа) уникальны и не превосходят 10<sup>9</sup>.

## Формат вывода

Для каждого из участков выведите расстояние до ближайшего нуля. Числа выводите в одну строку, разделяя их пробелами.

### Пример 1

| Ввод            | Вывод     |
|-----------------|-----------|
| 5<br/>0 1 4 9 0 | 0 1 2 1 0 |

### Пример 2

| Ввод               | Вывод       |
|--------------------|-------------|
| 6<br/>0 7 9 4 8 20 | 0 1 2 3 4 5 |