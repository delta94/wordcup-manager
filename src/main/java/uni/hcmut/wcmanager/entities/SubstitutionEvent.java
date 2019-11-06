package uni.hcmut.wcmanager.entities;

import uni.hcmut.wcmanager.randomizers.CoachSimulator;

public class SubstitutionEvent extends Event {
    public SubstitutionEvent(Match match, PlayerInMatch actor, int at) {
        super(match, actor, at);
    }

    @Override
    public void handle() {
        TeamInMatch outPlayersTeam = actor.getTeamInMatch();

        if (!outPlayersTeam.isAbleToSubstitute()) {
            String teamName = outPlayersTeam.getTeam().getName();
            System.out.printf("❎ %s is not able to substitute player\n", teamName);
            return;
        }

        PlayerInMatch outPlayer = actor;
        PlayerInMatch inPlayer = CoachSimulator.chooseRandomPlayer(outPlayersTeam.getBenchPlayers());
        outPlayersTeam.substitutePlayer(outPlayer, inPlayer);
    }
}
