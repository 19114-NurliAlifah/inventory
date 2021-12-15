-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 16, 2021 at 04:39 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.3.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projek`
--

-- --------------------------------------------------------

--
-- Table structure for table `nota`
--

CREATE TABLE `nota` (
  `no_nota` varchar(10) NOT NULL,
  `id_user` int(11) NOT NULL,
  `customer` varchar(30) NOT NULL,
  `total_harga` int(11) NOT NULL,
  `tunai` int(11) NOT NULL,
  `kembali` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nota`
--

INSERT INTO `nota` (`no_nota`, `id_user`, `customer`, `total_harga`, `tunai`, `kembali`) VALUES
('NT0001', 2, 'Lailla', 0, 0, 0),
('NT0002', 2, 'Raffi', 18000, 20000, 2000),
('NT0003', 2, '', 0, 0, 0),
('NT0004', 2, '', 0, 0, 0),
('NT0005', 2, '', 0, 0, 0),
('NT0006', 2, '', 0, 0, 0),
('NT0007', 2, '', 0, 0, 0),
('NT0008', 2, '', 0, 0, 0),
('NT0009', 2, '', 0, 0, 0),
('NT0010', 2, '', 0, 0, 0),
('NT0011', 2, 'Anita', 12000, 20000, 8000);

-- --------------------------------------------------------

--
-- Table structure for table `stok`
--

CREATE TABLE `stok` (
  `id_barang` varchar(10) NOT NULL,
  `nama_barang` varchar(100) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `stok`
--

INSERT INTO `stok` (`id_barang`, `nama_barang`, `harga`, `stok`) VALUES
('A0001', 'Buku', 4000, 47),
('A0002', 'Pensil', 2000, 66),
('A0003', 'Penghapus', 5000, 50);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `id_barang` varchar(10) NOT NULL,
  `no_nota` varchar(10) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `harga` int(11) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_barang`, `no_nota`, `jumlah`, `harga`, `tanggal`) VALUES
(30, 'A0001', 'NT0001', 3, 12000, '2021-06-16'),
(31, 'A0002', 'NT0001', 2, 4000, '2021-06-16'),
(32, 'A0002', 'NT0002', 5, 10000, '2021-06-16'),
(33, 'A0001', 'NT0002', 2, 8000, '2021-06-16'),
(35, 'A0002', 'NT0003', 2, 4000, '2021-06-16'),
(36, 'A0002', 'NT0003', 2, 4000, '2021-06-16'),
(37, 'A0002', 'NT0003', 2, 4000, '2021-06-16'),
(38, 'A0001', 'NT0004', 3, 12000, '2021-06-16'),
(39, 'A0001', 'NT0005', 5, 20000, '2021-06-16'),
(40, 'A0002', 'NT0005', 3, 20000, '2021-06-16'),
(41, 'A0001', 'NT0006', 3, 12000, '2021-06-16'),
(42, 'A0001', 'NT0006', 2, 8000, '2021-06-16'),
(43, 'A0001', 'NT0007', 3, 12000, '2021-06-16'),
(45, 'A0002', 'NT0008', 5, 10000, '2021-06-16'),
(46, 'A0001', 'NT0008', 3, 12000, '2021-06-16'),
(47, 'A0002', 'NT0010', 3, 6000, '2021-06-16'),
(48, 'A0001', 'NT0011', 3, 12000, '2021-06-16');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` enum('Inventory','Transaksi') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `status`) VALUES
(1, 'admin1', 'e00cf25ad42683b3df678c61f42c6bda', 'Inventory'),
(2, 'admin2', 'c84258e9c39059a89ab77d846ddab909', 'Transaksi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`no_nota`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_barang` (`id_barang`),
  ADD KEY `no_nota` (`no_nota`),
  ADD KEY `id_barang_2` (`id_barang`),
  ADD KEY `id_barang_3` (`id_barang`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `nota_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_barang`) REFERENCES `stok` (`id_barang`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`no_nota`) REFERENCES `nota` (`no_nota`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
