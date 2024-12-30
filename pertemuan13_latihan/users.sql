-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 30, 2024 at 08:19 AM
-- Server version: 8.0.30
-- PHP Version: 8.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pp2_mvc`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`) VALUES
(1, 'User1', 'user1@example.com'),
(2, 'User2', 'user2@example.com'),
(3, 'User3', 'user3@example.com'),
(4, 'User4', 'user4@example.com'),
(5, 'User5', 'user5@example.com'),
(6, 'User6', 'user6@example.com'),
(7, 'User7', 'user7@example.com'),
(8, 'User8', 'user8@example.com'),
(9, 'User9', 'user9@example.com'),
(10, 'User10', 'user10@example.com'),
(11, 'User11', 'user11@example.com'),
(12, 'User12', 'user12@example.com'),
(13, 'User13', 'user13@example.com'),
(14, 'User14', 'user14@example.com'),
(15, 'User15', 'user15@example.com'),
(16, 'User16', 'user16@example.com'),
(17, 'User17', 'user17@example.com'),
(18, 'User18', 'user18@example.com'),
(19, 'User19', 'user19@example.com'),
(20, 'User20', 'user20@example.com'),
(21, 'User21', 'user21@example.com'),
(22, 'User22', 'user22@example.com'),
(23, 'User23', 'user23@example.com'),
(24, 'User24', 'user24@example.com'),
(25, 'User25', 'user25@example.com'),
(26, 'User26', 'user26@example.com'),
(27, 'User27', 'user27@example.com'),
(28, 'User28', 'user28@example.com'),
(29, 'User29', 'user29@example.com'),
(30, 'User30', 'user30@example.com'),
(31, 'User31', 'user31@example.com'),
(32, 'User32', 'user32@example.com'),
(33, 'User33', 'user33@example.com'),
(34, 'User34', 'user34@example.com'),
(35, 'User35', 'user35@example.com'),
(36, 'User36', 'user36@example.com'),
(37, 'User37', 'user37@example.com'),
(38, 'User38', 'user38@example.com'),
(39, 'User39', 'user39@example.com'),
(40, 'User40', 'user40@example.com'),
(41, 'User41', 'user41@example.com'),
(42, 'User42', 'user42@example.com'),
(43, 'User43', 'user43@example.com'),
(44, 'User44', 'user44@example.com'),
(45, 'User45', 'user45@example.com'),
(46, 'User46', 'user46@example.com'),
(47, 'User47', 'user47@example.com'),
(48, 'User48', 'user48@example.com'),
(49, 'User49', 'user49@example.com'),
(50, 'User50', 'user50@example.com'),
(51, 'User51', 'user51@example.com'),
(52, 'User52', 'user52@example.com'),
(53, 'User53', 'user53@example.com'),
(54, 'User54', 'user54@example.com'),
(55, 'User55', 'user55@example.com'),
(56, 'User56', 'user56@example.com'),
(57, 'User57', 'user57@example.com'),
(58, 'User58', 'user58@example.com'),
(59, 'User59', 'user59@example.com'),
(60, 'User60', 'user60@example.com'),
(61, 'User61', 'user61@example.com'),
(62, 'User62', 'user62@example.com'),
(63, 'User63', 'user63@example.com'),
(64, 'User64', 'user64@example.com'),
(65, 'User65', 'user65@example.com'),
(66, 'User66', 'user66@example.com'),
(67, 'User67', 'user67@example.com'),
(68, 'User68', 'user68@example.com'),
(69, 'User69', 'user69@example.com'),
(70, 'User70', 'user70@example.com'),
(71, 'User71', 'user71@example.com'),
(72, 'User72', 'user72@example.com'),
(73, 'User73', 'user73@example.com'),
(74, 'User74', 'user74@example.com'),
(75, 'User75', 'user75@example.com'),
(76, 'User76', 'user76@example.com'),
(77, 'User77', 'user77@example.com'),
(78, 'User78', 'user78@example.com'),
(79, 'User79', 'user79@example.com'),
(80, 'User80', 'user80@example.com'),
(81, 'User81', 'user81@example.com'),
(82, 'User82', 'user82@example.com'),
(83, 'User83', 'user83@example.com'),
(84, 'User84', 'user84@example.com'),
(85, 'User85', 'user85@example.com'),
(86, 'User86', 'user86@example.com'),
(87, 'User87', 'user87@example.com'),
(88, 'User88', 'user88@example.com'),
(89, 'User89', 'user89@example.com'),
(90, 'User90', 'user90@example.com'),
(91, 'User91', 'user91@example.com'),
(92, 'User92', 'user92@example.com'),
(93, 'User93', 'user93@example.com'),
(94, 'User94', 'user94@example.com'),
(95, 'User95', 'user95@example.com'),
(96, 'User96', 'user96@example.com'),
(97, 'User97', 'user97@example.com'),
(98, 'User98', 'user98@example.com'),
(99, 'User99', 'user99@example.com'),
(100, 'User100', 'user100@example.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=704;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
