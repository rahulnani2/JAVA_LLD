package TicTacToe.Models;

import TicTacToe.Enums.BotDifficultyLevel;
import TicTacToe.Enums.playerType;
import TicTacToe.Strategies.botPlayingStrategies.BotPlayingStrategy;
import TicTacToe.Strategies.botPlayingStrategies.BotPlayingStrategyFactory;

public class Bot extends Player {
    BotDifficultyLevel botDifficultyLevel ;
    BotPlayingStrategy botPlayingStrategy ;

    public Bot(int id, String name, Symbol symbol , BotDifficultyLevel botDifficultyLevel) {
        super(id, name , TicTacToe.Enums.playerType.BOT , symbol) ;
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getbotPlayingStrategyByLevel(botDifficultyLevel) ;
    }
    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board) ;
        move.setPlayer(this);
        return move ;
    }


}
