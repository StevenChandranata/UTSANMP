-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 20, 2024 at 04:00 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `utsanmp`
--

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `idGame` int(11) NOT NULL,
  `title` longtext NOT NULL,
  `description` longtext NOT NULL,
  `imageUrl` longtext NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`idGame`, `title`, `description`, `imageUrl`, `user_id`) VALUES
(1, 'Honkai: Star Rail Confirms Aventurine and Jingliu Character and Light Cone Warp Duration', 'Honkai: Star Rail officially reveals the exact release and end dates of the upcoming banners that will feature five-star units Aventurine and Jingliu.', 'https://dotesports.com/wp-content/uploads/2024/01/aventurine-art-honkai-star-rail.jpg', 1),
(2, 'Helldivers 2 Dev Talks About the Possibility of Adding Melee Weapons', 'Helldivers 2 fans have been asking for melee weapons for a long time now, and the developers highlight their stance on the much-awaited inclusion.', 'https://cdn.mos.cms.futurecdn.net/3srkMzCrgBNVs2PK5WwMN-1200-80.png', 2),
(3, 'Call of Duty: Modern Warfare 3 Will Begin Testing Restricted Weapons in Ranked Play', 'Call of Duty Modern Warfare 3 Developer Treyarch Studios says that an upcoming test will add several otherwise restricted weapons to ranked play.', 'https://cdn.gamerwk.com/2023/11/COD-MW3-16-Bulan-1.jpg', 3),
(4, 'The Witcher 3: Wild Hunt for Switch Is Cheapest yet on Amazon', 'Switch gamers looking for an amazing action RPG experience at a bargain, look no further than this The Witcher 3: Wild Hunt deal.', 'https://static.cdprojektred.com/thewitcher.com/gfx/witcher3/thumbnail-tw.jpg', 4),
(5, 'Genshin Impact Chart Shows Sales Difference Between Neuvillette and Kazuha', 'A Genshin Impact revenue report reveals the sales difference between the two units featured on the ongoing limited banner: Neuvillette and Kazuha.', 'https://staticg.sportskeeda.com/editor/2024/03/5ee8b-17097247785902-1920.jpg', 5);

-- --------------------------------------------------------

--
-- Table structure for table `gamedetail`
--

CREATE TABLE `gamedetail` (
  `idGame` int(11) NOT NULL,
  `idGameDetail` int(11) NOT NULL,
  `descriptionDetail` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `gamedetail`
--

INSERT INTO `gamedetail` (`idGame`, `idGameDetail`, `descriptionDetail`) VALUES
(1, 1, 'Honkai: Star Rail has officially revealed the duration of the upcoming Character and Light Cone Warp Event that will feature the new five-star character Aventurine and a re-run for the previously released Jingliu. Despite being released less than a year ago, the game has already introduced a multitude of new characters, which allows HoYoverse to frequently include double banners in their updates.'),
(1, 2, 'Honkai: Star Rail\'s double banner mechanic allows players to pull for two different five-star characters at the same time. The 90-wish pity count and the four-star lineup, which consists of three characters, is shared between the two banners. Both characters will arrive as part of the second banner cycle of the ongoing Version 2.1.'),
(1, 3, 'Honkai: Star Rail\'s official X account has confirmed the start and end dates of the upcoming Aventurine and Jingliu banners. According to the announcement, Aventurine and Jingliu, along with their Light Cones, will be available from April 17 at 12:00 PM to May 7 at 3:00 PM, server time. Aventurine is introduced as a senior manager in the Strategic Investment Department of the IPC, known for his frivolous behavior and willingness to take risks. Aventurine was originally named Kakavasha, and he comes from Sigonia IV, a desert planet located at the intersection of the Dnies, Dorneau, and Pruthian star clusters. The official storyline has confirmed that he works alongside Topaz, another playable character who was introduced back in Honkai: Star Rail Version 1.4.'),
(2, 4, 'Helldivers 2\'s meta might change significantly in the near future, with the developers suggesting a possibility of melee weapons being introduced to the game. Fans have been asking for the addition of melee weapons ever since Helldivers 2 was released, and it seems like the developers aren\'t ruling out the idea completely.'),
(2, 5, 'The past few weeks have been quite eventful for fans, with the new Democratic Detonation Warbond adding weapons like the R-36 Eruptor and GP-31 Grenade Pistol to Helldivers 2 alongside a plethora of other additions. However, there were a few drawbacks as well, as a several issues seeped in with the new update. For instance, the increased fire damage is something that the community is not quite fond of, and the developers have assured fans that they will be addressing it. However, apart from the fixes, it seems like the developers might have some more exciting features in store for fans, which they have been demanding.'),
(2, 6, 'On the official Helldivers 2 Discord channel (via GamesRadar+), user sanest creeker enquired community manager Twinbeard about whether melee weapons are still a part of the developer\'s plans. Replying with a wink emoji, they emphasized how busy the developers have been lately, especially in the past month, with the release of several new updates for Helldivers 2. \"Well, it\'s been a month, not a year. It might still happen,\" Twinbread adds.'),
(3, 7, 'Some currently restricted weapons may be coming to Call of Duty: Modern Warfare 3 ranked play modes in an upcoming test. Developers Treyarch Studios and Sledgehammer games announced that a planned evaluation of various Call of Duty: Modern Warfare 3 weapons will take place to determine the weapons\' viability in the competitive scene.'),
(3, 8, 'Maintaining one of the most popular multiplayer games in the world takes a lot of testing and resources, and Call of Duty: Modern Warfare 3 is no exception to that rule. With vast player counts constantly competing for supremacy on the game\'s leaderboards and ranking systems, Call of Duty needs constant adjustment via patches and updates to keep up with the pace of players pushing at the game\'s limits and finding new \"meta\" strategies and loadouts to guarantee victory. As a matter of course, developers like Treyarch and Sledgehammer conduct limited testing on live servers to take advantage of the huge player population, using live tests to gather crucial data on any given item or strategy\'s impact on the competitive scene.'),
(3, 9, 'The latest live test planned for the Call of Duty: Modern Warfare 3 competitive environment is what Treyarch calls a \"Weapon Evaluation.\" The test follows from the success of a previous \"Map Evaluation,\" which returned several restricted maps to the game\'s Ranked play rotation. The Weapon Evaluation will, according to an announcement made on Treyarch\'s official social media accounts, add several weapons that are currently restricted from selection in ranked play. Given that any additions or removals can shake up how players decide which weapons are the latest Call of Duty meta guns, Weapon Evaluations can have significant consequences for the competitive scene.'),
(4, 10, 'Gamers on the lookout for epic adventures can now grab The Witcher 3: Wild Hunt for Nintendo Switch at a solid discount on Amazon. With a 12% reduction, the price drops to $36.07 from the typical listing price of $41.15 on the platform. Now with these additional savings, the game is the cheapest its ever been for Nintendo Switch on Amazon. This makes it the optimal time to get into one of the most critically acclaimed action RPGs ever!'),
(4, 11, 'CD Projekt Red is the studio behind The Witcher 3: Wild Hunt. The game company made its name with the Witcher series but has since become a major name in the industry with titles like Cyberpunk 2077 and its DLC Phantom Liberty. The success and popularity of the Witcher game series were likely an important force behind the adaptation of Andrzej Sapkowski\'s work into a Netflix series, as well.'),
(5, 12, 'A new Genshin Impact chart has revealed the revenue difference between the two currently available limited characters, the Hydro dragon Neuvillette and the Anemo user Kaedehara Kazuha. As the game\'s playable roster keeps expanding with each new version of the game, HoYoverse has been featuring double banners in every banner cycle.'),
(5, 13, 'Genshin Impact updates are divided into two banner cycles, each of which features a different set of limited characters and weapons that are available for approximately three weeks. The first part of the ongoing Version 4.5 offered two Geo users, the new five-star character Chiori and the famous leader of the Arataki gang known as Itto.'),
(5, 14, 'A popular Genshin Impact stats website called Paimon.moe has revealed the sales difference between Kazuha and Neuvillette. According to the chart, Neuvillette accounted for around 65.9% of the overall banner revenue, compared to Kazuha\'s 34.1%. The difference does not come as a surprise, considering that Neuvillette was released in Genshin Impact Version 4.1 and this is his first re-run. He is widely thought to be the best Hydro DPS character in the game thanks to a stacked kit that can deal tons of AoE damage. On the other hand, Kazuha is an Anemo user who can fit in almost any team composition that needs a neutral support. The banner also features a decent four-star lineup that includes Xingqiu, Yanfei, and Barbara.');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `imageProfil` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `firstname`, `lastname`, `email`, `password`, `imageProfil`) VALUES
(1, '1', 'mama', 'chandranata', 'steven@gmail.com', '1', 'https://img.uncyc.org/id/e/ec/Si_Ganteng.jpg'),
(2, 'maxWin', 'dani', 'tampan', 'dani@gmail.com', '123', 'https://c.files.bbci.co.uk/1BA0/production/_116327070_3ddda0d3-7160-4801-9b56-7771baca7dbb.jpg'),
(3, 'Dragon101', 'shyarlla', 'nurma', 'shyarlla@gmaiil.com', '123', 'https://upload.wikimedia.org/wikipedia/commons/0/09/Ayam_Pelung.jpg'),
(4, 'myguy', 'kamin', 'opra', 'kamin@gmail.com', '123', 'https://cdn.pixabay.com/photo/2016/02/10/16/37/cat-1192026_1280.jpg'),
(5, 'alpha', 'nirmala', 'fitri', 'nirmala@gmail.com', '123', 'https://asset-2.tstatic.net/kupang/foto/bank/images/kucing-princess-aurora_20160910_221929.jpg'),
(7, '1', 'mama', 'chandranata', 'd', '1', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`idGame`),
  ADD KEY `fk_game_user_idx` (`user_id`);

--
-- Indexes for table `gamedetail`
--
ALTER TABLE `gamedetail`
  ADD PRIMARY KEY (`idGameDetail`),
  ADD KEY `fk_gameDetail_game1_idx` (`idGame`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `idGame` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `gamedetail`
--
ALTER TABLE `gamedetail`
  MODIFY `idGameDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `game`
--
ALTER TABLE `game`
  ADD CONSTRAINT `fk_game_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `gamedetail`
--
ALTER TABLE `gamedetail`
  ADD CONSTRAINT `fk_gamedetail_game1` FOREIGN KEY (`idGame`) REFERENCES `game` (`idGame`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
