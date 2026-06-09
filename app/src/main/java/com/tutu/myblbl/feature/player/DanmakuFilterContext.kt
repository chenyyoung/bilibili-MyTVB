package com.tutu.myblbl.feature.player

import com.tutu.myblbl.model.proto.DmSmartFilterConfigProto
import com.tutu.myblbl.model.proto.DmWebViewReplyProto
import com.tutu.myblbl.model.proto.DmRestrictPeriodProto
import com.tutu.myblbl.model.proto.DanmuWebPlayerConfigProto
import java.io.Serializable

data class DanmakuFilterContext(
    val smartFilterConfig: DmSmartFilterConfigProto = DmSmartFilterConfigProto(),
    val playerConfig: DanmuWebPlayerConfigProto = DanmuWebPlayerConfigProto(),
    val reportFilters: List<String> = emptyList(),
    val restrictPeriods: List<DmRestrictPeriodProto> = emptyList()
) : Serializable {
    companion object {
        val EMPTY = DanmakuFilterContext()

        fun fromView(view: DmWebViewReplyProto?): DanmakuFilterContext {
            if (view == null) return EMPTY
            return DanmakuFilterContext(
                smartFilterConfig = view.smartFilterConfig,
                playerConfig = view.playerConfig,
                reportFilters = view.reportFilters,
                restrictPeriods = view.restrictPeriods
            )
        }
    }
}
