package net.dabbit.skd21.exam.utils;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;



public class ExamGenerator {
    // 数据库连接工具类，请确保该类存在
    private static final ConnectionUtil connectionUtil = new ConnectionUtil();

    // 考试题目难度枚举
    public enum Difficulty {
        EASY, MEDIUM, HARD, VERY_HARD
    }

    public static void main(String[] args) throws Exception {
        String difficultyProportions = "5:3:1:1";
        int totalQuestions = 28;

        Map<Difficulty, Integer> questionsInDatabase = new HashMap<>();
        questionsInDatabase.put(Difficulty.EASY, 35);
        questionsInDatabase.put(Difficulty.MEDIUM, 8000);
        questionsInDatabase.put(Difficulty.HARD, 6000);
        questionsInDatabase.put(Difficulty.VERY_HARD, 3000);

        Map<Difficulty, Integer> questionsInPaper = calculateQuestionsPerDifficulty(difficultyProportions, totalQuestions);

        for (Difficulty difficulty : Difficulty.values()) {
            List<Integer> questionIds = fetchRandomQuestions(questionsInDatabase.get(difficulty), questionsInPaper.get(difficulty));
            System.out.println(difficulty.name() + " questions: " + questionIds);
        }
    }

    public static Map<Difficulty, Integer> calculateQuestionsPerDifficulty(String difficultyProportions, int totalQuestions) {
        String[] proportions = difficultyProportions.split(":");
        int sumOfProportions = Arrays.stream(proportions).mapToInt(Integer::parseInt).sum();

        Map<Difficulty, Integer> questionsPerDifficulty = new HashMap<>();
        questionsPerDifficulty.put(Difficulty.EASY, totalQuestions * Integer.parseInt(proportions[0]) / sumOfProportions);
        questionsPerDifficulty.put(Difficulty.MEDIUM, totalQuestions * Integer.parseInt(proportions[1]) / sumOfProportions);
        questionsPerDifficulty.put(Difficulty.HARD, totalQuestions * Integer.parseInt(proportions[2]) / sumOfProportions);
        questionsPerDifficulty.put(Difficulty.VERY_HARD, totalQuestions * Integer.parseInt(proportions[3]) / sumOfProportions);

        return questionsPerDifficulty;
    }

    public static List<Integer> fetchRandomQuestions(int totalQuestionsInDB, int questionsNeeded) throws Exception {
        int pageSize = totalQuestionsInDB / questionsNeeded;
        int remainder = totalQuestionsInDB % questionsNeeded;

        List<Map<String, Integer>> pageInfoList = new ArrayList<>();

        for (int i = 0; i < questionsNeeded; i++) {
            Map<String, Integer> pageInfo = new HashMap<>();
            if (i == questionsNeeded - 1 && remainder > 0) {
                pageInfo.put("offset", i * pageSize);
                pageInfo.put("pageSize", remainder);
            } else {
                pageInfo.put("offset", i * pageSize);
                pageInfo.put("pageSize", pageSize);
            }
            pageInfoList.add(pageInfo);
        }

        List<Integer> allQuestionIds = new ArrayList<>();
        for (Map<String, Integer> pageInfo : pageInfoList) {
            allQuestionIds.addAll(getQuestionIds(pageInfo));
        }

        Collections.shuffle(allQuestionIds);
        return allQuestionIds.stream().limit(questionsNeeded).collect(Collectors.toList());
    }

    private static List<Integer> getQuestionIds(Map<String, Integer> pageInfo) throws Exception {
        List<Integer> ids = new ArrayList<>();

        String sqlTemplate = "SELECT id FROM question_bank LIMIT ?, ?";
        try (Connection conn = connectionUtil.getConnection();
             PreparedStatement pst = conn.prepareStatement(sqlTemplate)) {
            pst.setInt(1, pageInfo.get("offset"));
            pst.setInt(2, pageInfo.get("pageSize"));

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ids.add(rs.getInt("id"));
            }
        }

        return ids;
    }


    private static class ConnectionUtil {
        private static final String URL = "jdbc:mysql://super-rabbit.dayi.ink:18206/ovo";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "123456";

        public Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }

        public static void releaseConnection(Connection connection) {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


