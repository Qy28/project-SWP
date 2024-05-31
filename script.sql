USE [master]
GO
/****** Object:  Database [English_Sprout]    Script Date: 5/31/2024 1:45:31 PM ******/
CREATE DATABASE [English_Sprout]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'English_Sprout', FILENAME = N'D:\Sql\MSSQL16.MSSQLSERVER\MSSQL\DATA\English_Sprout.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'English_Sprout_log', FILENAME = N'D:\Sql\MSSQL16.MSSQLSERVER\MSSQL\DATA\English_Sprout_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [English_Sprout] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [English_Sprout].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [English_Sprout] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [English_Sprout] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [English_Sprout] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [English_Sprout] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [English_Sprout] SET ARITHABORT OFF 
GO
ALTER DATABASE [English_Sprout] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [English_Sprout] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [English_Sprout] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [English_Sprout] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [English_Sprout] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [English_Sprout] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [English_Sprout] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [English_Sprout] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [English_Sprout] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [English_Sprout] SET  ENABLE_BROKER 
GO
ALTER DATABASE [English_Sprout] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [English_Sprout] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [English_Sprout] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [English_Sprout] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [English_Sprout] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [English_Sprout] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [English_Sprout] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [English_Sprout] SET RECOVERY FULL 
GO
ALTER DATABASE [English_Sprout] SET  MULTI_USER 
GO
ALTER DATABASE [English_Sprout] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [English_Sprout] SET DB_CHAINING OFF 
GO
ALTER DATABASE [English_Sprout] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [English_Sprout] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [English_Sprout] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [English_Sprout] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'English_Sprout', N'ON'
GO
ALTER DATABASE [English_Sprout] SET QUERY_STORE = ON
GO
ALTER DATABASE [English_Sprout] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [English_Sprout]
GO
/****** Object:  Table [dbo].[Author]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Author](
	[Pid] [varchar](320) NOT NULL,
	[Rating] [decimal](1, 0)  NULL,
PRIMARY KEY CLUSTERED 
(
	[Pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Learner]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Learner](
	[Pid] [varchar](320) NOT NULL,
	[Grade] [decimal](2, 2)  NULL,
	[rank] [decimal](1, 0) NULL,
PRIMARY KEY CLUSTERED 
(
	[Pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Person]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Person](
	[Pid] [varchar](320) NOT NULL,
	[name] [varchar](20) NULL,
	[PassWord] [varchar](20) NOT NULL,
	[DoB] [date] NULL,
	[PhoneNumber] [varchar](12) NULL,
	[Role] [decimal](1, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PurchaseHistory]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PurchaseHistory](
	[Pid] [varchar](320) NOT NULL,
	[Purchase] [int] NOT NULL,
	[Start_Date] [date] NOT NULL,
	[Details] [varchar](14) NULL,
PRIMARY KEY CLUSTERED 
(
	[Pid] ASC,
	[Start_Date] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Question]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[QuestionId] [int] NOT NULL,
	[TestId] [int] not NULL,
	[QuestionTypeId] [decimal](10, 0) not NULL,
	[Detail] [text] NOT NULL,
	[Answer] [varchar](64) NOT NULL,
	[AnswerDescription] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[QuestionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuestionAnswerDetail]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuestionAnswerDetail](
	[QuestionId] [int] NOT NULL,
	[QuestionAnswer] [text] NOT NULL,
	[QuestionState] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[QuestionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuestionHistory]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuestionHistory](
	[Pid] [varchar](320) NOT NULL,
	[QuestionId] [int] NOT NULL,
	[Result] [text] NULL,
PRIMARY KEY CLUSTERED 
(
	[Pid] ASC,
	[QuestionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[QuestionType]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QuestionType](
	[QuestionTypeId] [decimal](10, 0) NOT NULL,
	[TypeName] [varchar](16) not NULL,
	[NumsOfQuestion] [decimal](2, 0) default 1,
PRIMARY KEY CLUSTERED 
(
	[QuestionTypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SystemFeedback]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SystemFeedback](
	[Pid1] [varchar](320) NOT NULL,
	[Pid2] [varchar](320) NOT NULL,
	[Date] [date] NULL,
	[Description] [text] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Pid1] ASC,
	[Pid2] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Test]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test](
	[TestId] [int] NOT NULL,
	[Title] [varchar](64) default 'No title Test',
	[Pid] [varchar](320) null,
	[Level] [decimal](2, 0) not NULL,
	[Date] [date] NULL,
	[State] bit NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[TestId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TestFeedback]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestFeedback](
	[TestId] [int] NOT NULL,
	[Pid] [varchar](320) NOT NULL,
	[Description] [text] not NULL,
PRIMARY KEY CLUSTERED 
(
	[TestId] ASC,
	[Pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TestHistory]    Script Date: 5/31/2024 1:45:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestHistory](
	[Pid] [varchar](320) not NULL,
	[TestId] [int] not NULL,
	[TimeTake] [date] NOT NULL,
	[Result] [text] not NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Author]  WITH CHECK ADD FOREIGN KEY([Pid])
REFERENCES [dbo].[Person] ([Pid])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Learner]  WITH CHECK ADD FOREIGN KEY([Pid])
REFERENCES [dbo].[Person] ([Pid])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[PurchaseHistory]  WITH CHECK ADD FOREIGN KEY([Pid])
REFERENCES [dbo].[Learner] ([Pid])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Question]  WITH CHECK ADD FOREIGN KEY([QuestionTypeId])
REFERENCES [dbo].[QuestionType] ([QuestionTypeId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Question]  WITH CHECK ADD FOREIGN KEY([TestId])
REFERENCES [dbo].[Test] ([TestId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[QuestionAnswerDetail]  WITH CHECK ADD FOREIGN KEY([QuestionId])
REFERENCES [dbo].[Question] ([QuestionId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[QuestionHistory]  WITH CHECK ADD FOREIGN KEY([QuestionId])
REFERENCES [dbo].[Question] ([QuestionId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[QuestionHistory]  WITH CHECK ADD FOREIGN KEY([Pid])
REFERENCES [dbo].[Learner] ([Pid])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SystemFeedback]  WITH CHECK ADD FOREIGN KEY([Pid1])
REFERENCES [dbo].[Person] ([Pid])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[SystemFeedback]  WITH CHECK ADD FOREIGN KEY([Pid2])
REFERENCES [dbo].[Person] ([Pid])
GO
ALTER TABLE [dbo].[Test]  WITH CHECK ADD FOREIGN KEY([Pid])
REFERENCES [dbo].[Author] ([Pid])
GO
ALTER TABLE [dbo].[TestFeedback]  WITH CHECK ADD FOREIGN KEY([TestId])
REFERENCES [dbo].[Test] ([TestId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TestFeedback]  WITH CHECK ADD FOREIGN KEY([Pid])
REFERENCES [dbo].[Learner] ([Pid])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TestHistory]  WITH CHECK ADD FOREIGN KEY([TestId])
REFERENCES [dbo].[Test] ([TestId])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TestHistory]  WITH CHECK ADD FOREIGN KEY([Pid])
REFERENCES [dbo].[Learner] ([Pid])
ON DELETE CASCADE
GO
USE [master]
GO
ALTER DATABASE [English_Sprout] SET  READ_WRITE 
GO
