# JavaVkTest
Тестовое задание на Java-стажировку в VK. Весна 2024.


Выполненные пункты задания:

1.Реализовать обработчики (GET, POST, PUT, DELETE), которые проксируют запросы к https://jsonplaceholder.typicode.com/
-/api/posts/**
-/api/users/**
-/api/albums/**

2.Реализовать базовую авторизацию, с несколькими аккаунтами, у которых будут разные роли.

3.Проработать ролевую модель доступа. Чтобы было минимум 4 роли - ROLE_ADMIN, ROLE_POSTS, ROLE_USERS, ROLE_ALBUMS

4.Реализовать ведение аудита действий.

5.Реализовать inmemory кэш, чтобы уменьшить число запросов к jsonplaceholder.

6.Использование базы данных:
-для ведением аудита,
-для хранения данных пользователей.

7.Расширенная ролевая модель. (например, ROLE_POSTS_VIEWER, ROLE_POSTS_EDITOR, …)