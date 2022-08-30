## I. Сапер

Вам необходимо построить поле для игры "Сапер" по его конфигурации – размерам и координатам расставленных на нем мин.

Вкратце напомним правила построения поля для игры "Сапер":

Поле состоит из клеток с минами и пустых клеток
Клетки с миной обозначаются символом *
Пустые клетки содержат число k_i,j, 0 ≤ k_i, j ≤ 8 – количество мин на соседних клетках. Соседними клетками являются восемь
клеток, имеющих смежный угол или сторону.

### Формат ввода

В первой строке содержатся три числа: N, 1 ≤ N ≤ 100 - количество строк на поле, M, 1 ≤ M ≤ 100 - количество столбцов на
поле, K, 0 ≤ K ≤ N ⋅ M - количество мин на поле.

В следующих K строках содержатся по два числа с координатами мин: p, 1 ≤ p ≤ N - номер строки мины, q, 1 ≤ 1 ≤ M - номер
столбца мины.

### Формат вывода

Выведите построенное поле, разделяя строки поля переводом строки, а столбцы - пробелом.