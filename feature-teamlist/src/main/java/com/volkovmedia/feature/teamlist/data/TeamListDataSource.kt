package com.volkovmedia.feature.teamlist.data

import com.volkovmedia.component.data.dao.TeamDao
import com.volkovmedia.component.data.model.entity.Team
import com.volkovmedia.feature.teamlist.domain.TeamListRepository
import io.reactivex.Completable

internal class TeamListDataSource(private val teamDao: TeamDao) : TeamListRepository {

    override fun getTeams() = teamDao.getTeamsWithParticipants()

    override fun removeTeam(team: Team) = Completable.fromAction { teamDao.remove(team) }

}