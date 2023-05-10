package com.example.diceassessmentandroid.home.model

import com.google.gson.annotations.SerializedName

data class SearchApiResponseModel (
    @SerializedName("total_count"        ) var totalCount        : Int?             = null,
    @SerializedName("incomplete_results" ) var incompleteResults : Boolean?         = null,
    @SerializedName("items"              ) var items             : ArrayList<Items> = arrayListOf()
)



data class Items (
    @SerializedName("url"                      ) var url                   : String?                = null,
    @SerializedName("repository_url"           ) var repositoryUrl         : String?                = null,
    @SerializedName("labels_url"               ) var labelsUrl             : String?                = null,
    @SerializedName("comments_url"             ) var commentsUrl           : String?                = null,
    @SerializedName("events_url"               ) var eventsUrl             : String?                = null,
    @SerializedName("html_url"                 ) var htmlUrl               : String?                = null,
    @SerializedName("id"                       ) var id                    : Int?                   = null,
    @SerializedName("node_id"                  ) var nodeId                : String?                = null,
    @SerializedName("number"                   ) var number                : Int?                   = null,
    @SerializedName("title"                    ) var title                 : String?                = null,
    @SerializedName("user"                     ) var user                  : User?                  = null,
    @SerializedName("labels"                   ) var labels                : ArrayList<Labels>      = arrayListOf(),
    @SerializedName("state"                    ) var state                 : String?                = null,
    @SerializedName("locked"                   ) var locked                : Boolean?               = null,
    @SerializedName("assignee"                 ) var assignee              : String?                = null,
    @SerializedName("assignees"                ) var assignees             : ArrayList<String>      = arrayListOf(),
    @SerializedName("milestone"                ) var milestone             : String?                = null,
    @SerializedName("comments"                 ) var comments              : Int?                   = null,
    @SerializedName("created_at"               ) var createdAt             : String?                = null,
    @SerializedName("updated_at"               ) var updatedAt             : String?                = null,
    @SerializedName("closed_at"                ) var closedAt              : String?                = null,
    @SerializedName("author_association"       ) var authorAssociation     : String?                = null,
    @SerializedName("active_lock_reason"       ) var activeLockReason      : String?                = null,
    @SerializedName("body"                     ) var body                  : String?                = null,
    @SerializedName("reactions"                ) var reactions             : Reactions?             = null,
    @SerializedName("timeline_url"             ) var timelineUrl           : String?                = null,
    @SerializedName("performed_via_github_app" ) var performedViaGithubApp : String?                = null,
    @SerializedName("state_reason"             ) var stateReason           : String?                = null,
    @SerializedName("score"                    ) var score                 : Int?                   = null,
    @SerializedName("text_matches"             ) var textMatches           : ArrayList<TextMatches> = arrayListOf()
)


data class User (

    @SerializedName("login"               ) var login             : String?  = null,
    @SerializedName("id"                  ) var id                : Int?     = null,
    @SerializedName("node_id"             ) var nodeId            : String?  = null,
    @SerializedName("avatar_url"          ) var avatarUrl         : String?  = null,
    @SerializedName("gravatar_id"         ) var gravatarId        : String?  = null,
    @SerializedName("url"                 ) var url               : String?  = null,
    @SerializedName("html_url"            ) var htmlUrl           : String?  = null,
    @SerializedName("followers_url"       ) var followersUrl      : String?  = null,
    @SerializedName("following_url"       ) var followingUrl      : String?  = null,
    @SerializedName("gists_url"           ) var gistsUrl          : String?  = null,
    @SerializedName("starred_url"         ) var starredUrl        : String?  = null,
    @SerializedName("subscriptions_url"   ) var subscriptionsUrl  : String?  = null,
    @SerializedName("organizations_url"   ) var organizationsUrl  : String?  = null,
    @SerializedName("repos_url"           ) var reposUrl          : String?  = null,
    @SerializedName("events_url"          ) var eventsUrl         : String?  = null,
    @SerializedName("received_events_url" ) var receivedEventsUrl : String?  = null,
    @SerializedName("type"                ) var type              : String?  = null,
    @SerializedName("site_admin"          ) var siteAdmin         : Boolean? = null

)

data class Labels (

    @SerializedName("id"          ) var id          : Int?     = null,
    @SerializedName("node_id"     ) var nodeId      : String?  = null,
    @SerializedName("url"         ) var url         : String?  = null,
    @SerializedName("name"        ) var name        : String?  = null,
    @SerializedName("color"       ) var color       : String?  = null,
    @SerializedName("default"     ) var default     : Boolean? = null,
    @SerializedName("description" ) var description : String?  = null

)


data class Reactions (

    @SerializedName("url"         ) var url        : String? = null,
    @SerializedName("total_count" ) var totalCount : Int?    = null,
    @SerializedName("+1"          ) var plusOne        : Int?    = null,
    @SerializedName("-1"          ) var minusOne         : Int?    = null,
    @SerializedName("laugh"       ) var laugh      : Int?    = null,
    @SerializedName("hooray"      ) var hooray     : Int?    = null,
    @SerializedName("confused"    ) var confused   : Int?    = null,
    @SerializedName("heart"       ) var heart      : Int?    = null,
    @SerializedName("rocket"      ) var rocket     : Int?    = null,
    @SerializedName("eyes"        ) var eyes       : Int?    = null

)


data class Matches (

    @SerializedName("text"    ) var text    : String?        = null,
    @SerializedName("indices" ) var indices : ArrayList<Int> = arrayListOf()

)


data class TextMatches (

    @SerializedName("object_url"  ) var objectUrl  : String?            = null,
    @SerializedName("object_type" ) var objectType : String?            = null,
    @SerializedName("property"    ) var property   : String?            = null,
    @SerializedName("fragment"    ) var fragment   : String?            = null,
    @SerializedName("matches"     ) var matches    : ArrayList<Matches> = arrayListOf()

)