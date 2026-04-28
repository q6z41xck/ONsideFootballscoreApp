package com.mateuszholik.data.extensions

import com.mateuszholik.common.extensions.toEnum
import com.mateuszholik.database.models.CompetitionDB
import com.mateuszholik.database.models.MatchInfoDB
import com.mateuszholik.database.models.MatchScoreDB
import com.mateuszholik.database.models.ScoreDB
import com.mateuszholik.database.models.TeamDB
import com.mateuszholik.model.Competition
import com.mateuszholik.model.CompetitionType
import com.mateuszholik.model.Duration
import com.mateuszholik.model.MatchInfo
import com.mateuszholik.model.MatchScore
import com.mateuszholik.model.Score
import com.mateuszholik.model.Status
import com.mateuszholik.model.Team
import com.mateuszholik.model.Winner

internal fun MatchInfoDB.toCommonModel(): MatchInfo =
    MatchInfo(
        id = id,
        homeTeam = homeTeam.toCommonModel(),
        awayTeam = awayTeam.toCommonModel(),
        score = score.toCommonModel(),
        status = status.toEnum(Status.N_A),
        utcDate = utcDate
    )

internal fun TeamDB.toCommonModel(): Team =
    Team(
        id = id,
        crest = crest,
        name = name,
        shortName = shortName,
        tla = tla
    )

internal fun MatchScoreDB.toCommonModel(): MatchScore =
    MatchScore(
        duration = duration.toEnum(Duration.N_A),
        fullTime = fullTime.toCommonModel(),
        halfTime = Score(null, null),
        winner = winner.toEnum(Winner.N_A)
    )

internal fun ScoreDB.toCommonModel(): Score =
    Score(
        away = away,
        home = home
    )

internal fun CompetitionDB.toCommonModel(): Competition =
    Competition(
        code = code,
        countryCode = countryCode,
        countryFlag = countryFlag,
        countryName = countryName,
        emblem = emblem,
        id = id,
        name = name,
        type = type.toEnum(CompetitionType.N_A)
    )
