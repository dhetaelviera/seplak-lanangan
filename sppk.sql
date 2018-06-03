-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2018 at 11:13 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sppk`
--

-- --------------------------------------------------------

--
-- Table structure for table `desa`
--

CREATE TABLE `desa` (
  `idDesa` int(11) NOT NULL,
  `kecamatan` int(11) NOT NULL,
  `desa` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `desa`
--

INSERT INTO `desa` (`idDesa`, `kecamatan`, `desa`) VALUES
(1, 1, 'sd'),
(2, 1, 'tst'),
(3, 2, 'st'),
(4, 2, 'tst'),
(5, 2, 'sdts');

-- --------------------------------------------------------

--
-- Table structure for table `jadwalsurvey`
--

CREATE TABLE `jadwalsurvey` (
  `idJadwal` int(11) NOT NULL,
  `jadwalsurvey` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jeniskelamin`
--

CREATE TABLE `jeniskelamin` (
  `idJK` int(11) NOT NULL,
  `jenisKelamin` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

--
-- Dumping data for table `jeniskelamin`
--

INSERT INTO `jeniskelamin` (`idJK`, `jenisKelamin`) VALUES
(1, 'laki-laki'),
(2, 'perempuan');

-- --------------------------------------------------------

--
-- Table structure for table `kecamatan`
--

CREATE TABLE `kecamatan` (
  `idKecamatan` int(11) NOT NULL,
  `kecamatan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kecamatan`
--

INSERT INTO `kecamatan` (`idKecamatan`, `kecamatan`) VALUES
(1, 'mana'),
(2, 'mini');

-- --------------------------------------------------------

--
-- Table structure for table `lahankosong`
--

CREATE TABLE `lahankosong` (
  `idLK` int(11) NOT NULL,
  `noTanah` varchar(13) NOT NULL,
  `alamatLK` varchar(100) NOT NULL,
  `kecamatanLK` int(11) NOT NULL,
  `desaLK` int(11) NOT NULL,
  `luas` int(11) NOT NULL,
  `scanSertifikat` varchar(255) NOT NULL,
  `statusTanah` int(11) NOT NULL DEFAULT '1',
  `jadwalsurvey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lahankosong`
--

INSERT INTO `lahankosong` (`idLK`, `noTanah`, `alamatLK`, `kecamatanLK`, `desaLK`, `luas`, `scanSertifikat`, `statusTanah`, `jadwalsurvey`) VALUES
(1, '5451', 'fcfcjg', 1, 2, 25, 'vgkvhlblh', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `statustanah`
--

CREATE TABLE `statustanah` (
  `idStatus` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `statustanah`
--

INSERT INTO `statustanah` (`idStatus`, `status`) VALUES
(1, 'Proses pengajuan'),
(2, 'akan disurvey'),
(3, 'proses survey'),
(4, 'batal sewa'),
(5, 'disewa');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `noKTP` varchar(16) NOT NULL,
  `tempatLahir` varchar(20) NOT NULL,
  `tanggalLahir` date NOT NULL,
  `jenisKelamin` int(11) NOT NULL,
  `noTelepon` varchar(13) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(8) NOT NULL,
  `level` enum('admin','pemilik','','') NOT NULL DEFAULT 'pemilik'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`idUser`, `nama`, `noKTP`, `tempatLahir`, `tanggalLahir`, `jenisKelamin`, `noTelepon`, `alamat`, `username`, `password`, `level`) VALUES
(1, 'dheta', '4565412365412365', '2018-05-19', '2018-05-19', 1, '081230175921', 'wqd', 'dheta', 'dheta', 'admin'),
(2, 'rhwje', '1478521478521478', '2018-05-31', '2018-05-31', 1, '0258965412541', 'efrew', 'hehe', 'hehe', 'pemilik'),
(3, 'wer', '0145236541254635', '2018-05-12', '2018-05-12', 2, '0254136541254', 'r3e', 'r3e', 'rer', 'pemilik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `desa`
--
ALTER TABLE `desa`
  ADD PRIMARY KEY (`idDesa`);

--
-- Indexes for table `jadwalsurvey`
--
ALTER TABLE `jadwalsurvey`
  ADD PRIMARY KEY (`idJadwal`);

--
-- Indexes for table `jeniskelamin`
--
ALTER TABLE `jeniskelamin`
  ADD PRIMARY KEY (`idJK`);

--
-- Indexes for table `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD PRIMARY KEY (`idKecamatan`);

--
-- Indexes for table `lahankosong`
--
ALTER TABLE `lahankosong`
  ADD PRIMARY KEY (`idLK`),
  ADD UNIQUE KEY `noTanah` (`noTanah`);

--
-- Indexes for table `statustanah`
--
ALTER TABLE `statustanah`
  ADD PRIMARY KEY (`idStatus`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `desa`
--
ALTER TABLE `desa`
  MODIFY `idDesa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `jadwalsurvey`
--
ALTER TABLE `jadwalsurvey`
  MODIFY `idJadwal` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `jeniskelamin`
--
ALTER TABLE `jeniskelamin`
  MODIFY `idJK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `kecamatan`
--
ALTER TABLE `kecamatan`
  MODIFY `idKecamatan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `lahankosong`
--
ALTER TABLE `lahankosong`
  MODIFY `idLK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `statustanah`
--
ALTER TABLE `statustanah`
  MODIFY `idStatus` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
