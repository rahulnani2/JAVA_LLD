package TicTacToe.Strategies.botPlayingStrategies;

import TicTacToe.Enums.BotDifficultyLevel;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getbotPlayingStrategyByLevel(BotDifficultyLevel botDifficultyLevel) {
        return new EasyBotPlayingStrategy() ;
     }
}
