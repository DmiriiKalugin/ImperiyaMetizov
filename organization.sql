-- phpMyAdmin SQL Dump
-- version 4.9.5deb2
-- https://www.phpmyadmin.net/
--
-- Хост: localhost:3306
-- Время создания: Июн 02 2020 г., 09:40
-- Версия сервера: 10.3.22-MariaDB-1:10.3.22+maria~bionic-log
-- Версия PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `imperiya`
--

-- --------------------------------------------------------

--
-- Структура таблицы `organization`
--

CREATE TABLE `organization` (
  `id` int(15) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8 NOT NULL,
  `inn` varchar(150) CHARACTER SET utf8 NOT NULL,
  `kpp` varchar(150) CHARACTER SET utf8mb4 NOT NULL,
  `ogrn` varchar(150) CHARACTER SET utf8mb4 NOT NULL,
  `director` varchar(150) CHARACTER SET utf8mb4 NOT NULL,
  `adres` varchar(150) CHARACTER SET utf8mb4 NOT NULL,
  `number` varchar(150) CHARACTER SET utf8mb4 NOT NULL,
  `info` varchar(150) CHARACTER SET utf8mb4 NOT NULL,
  `omts` varchar(150) CHARACTER SET utf8mb4 NOT NULL,
  `sales` varchar(150) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Дамп данных таблицы `organization`
--

INSERT INTO `organization` (`id`, `name`, `inn`, `kpp`, `ogrn`, `director`, `adres`, `number`, `info`, `omts`, `sales`) VALUES
(1, 'ООО \"ИМПЕРИЯ\"', '6670492711', '667001001', '1206600021396', 'Карбушев Никита Александрович', '620062, Свердловская область, город Екатеринбург, проспект Ленина, дом 97а, офис 132', '+7 (343) 938-88-79', 'info@imperiya-metizov.ru', 'omts@imperiya-metizov.ru', 'sales@imperiya-metizov.ru');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `organization`
--
ALTER TABLE `organization`
  MODIFY `id` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
