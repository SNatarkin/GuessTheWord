# Игра угадай слово
Приложение загадывает слово выбирая случайное из специального банка. Банк реализуется как массив в памяти и задается кодом. Пользователь угадывает слово через интерфейс командной строки вводя по 1 букве или слово целиком если уже готов угадать. Если игрок вводит слово и оно неправильное, то он автоматом проигрывает.
Пример взаимодействия с игрой:
Key in one character or your guess word: t

Trial 1: t__t___
Key in one character or your guess word: g

Trial 2: t__t__g
Key in one character or your guess word: e

Trial 3: te_t__g

Key in one character or your guess word: testing

Congratulation!
You got in 4 trials
