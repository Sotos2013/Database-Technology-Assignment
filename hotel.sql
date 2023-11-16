-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: 127.0.0.1
-- Χρόνος δημιουργίας: 15 Νοε 2023 στις 13:42:48
-- Έκδοση διακομιστή: 10.4.27-MariaDB
-- Έκδοση PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `hotel`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `customer`
--

CREATE TABLE `customer` (
  `ID` varchar(30) NOT NULL,
  `Αριθμός Εγγράφου` varchar(30) NOT NULL,
  `Όνομα` varchar(30) NOT NULL,
  `Επώνυμο` varchar(30) NOT NULL,
  `Φύλο` varchar(30) NOT NULL,
  `Χώρα Διαμονής` varchar(30) NOT NULL,
  `Αριθμός δωματίου` int(4) NOT NULL,
  `Προσέλευση` varchar(30) NOT NULL,
  `Ποσό Πληρωμής` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `department`
--

CREATE TABLE `department` (
  `department` varchar(30) NOT NULL,
  `budget` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `driver`
--

CREATE TABLE `driver` (
  `name` varchar(30) NOT NULL,
  `age` varchar(10) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `company` varchar(30) NOT NULL,
  `brand` varchar(30) NOT NULL,
  `available` varchar(10) NOT NULL,
  `location` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `employee`
--

CREATE TABLE `employee` (
  `name` varchar(30) NOT NULL,
  `surname` varchar(30) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` varchar(30) NOT NULL,
  `job` varchar(30) NOT NULL,
  `salary` int(6) NOT NULL,
  `phone` int(30) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `login`
--

CREATE TABLE `login` (
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `last_login` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Άδειασμα δεδομένων του πίνακα `login`
--

INSERT INTO `login` (`username`, `password`, `last_login`) VALUES
('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2023-11-09 12:15:49');

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `room`
--

CREATE TABLE `room` (
  `Αριθμός δωματίου` int(4) NOT NULL,
  `Διαθεσιμότητα` varchar(20) NOT NULL,
  `Καθαρισμός` varchar(20) NOT NULL,
  `Τιμή` varchar(20) NOT NULL,
  `Αριθμός κρεβατιών` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;


--
-- Ευρετήρια για άχρηστους πίνακες
--

--
-- Ευρετήρια για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Αριθμός Εγγράφου`),
  ADD KEY `Αριθμός δωματίου` (`Αριθμός δωματίου`);

--
-- Ευρετήρια για πίνακα `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`Αριθμός δωματίου`);

--
-- Περιορισμοί για άχρηστους πίνακες
--

--
-- Περιορισμοί για πίνακα `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Αριθμός δωματίου`) REFERENCES `room` (`Αριθμός δωματίου`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
