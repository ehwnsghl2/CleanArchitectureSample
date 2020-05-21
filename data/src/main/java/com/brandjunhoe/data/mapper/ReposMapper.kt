package com.brandjunhoe.data.mapper

import com.brandjunhoe.data.entity.ReposEntity
import com.brandjunhoe.domain.entity.Repos
import javax.inject.Inject

class ReposMapper @Inject constructor() :
    Mapper<List<ReposEntity>, List<Repos>> {
    override fun mapFromEntity(type: List<ReposEntity>): List<Repos> {
        return type.map {
            with(it) {
                Repos(
                    name, description
                )
            }
        }
    }
}
