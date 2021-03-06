package com.bitlove.fetlife.model.dataobject.entity.reference

import com.bitlove.fetlife.model.dataobject.entity.content.ContentEntity
import com.bitlove.fetlife.model.dataobject.wrapper.Content
import com.google.gson.annotations.SerializedName

data class Picture(
        @SerializedName("id") var id: String = "",
        @SerializedName("member") var memberRef: MemberRef,
        @SerializedName("content_type") var contentType: String = "",
        @SerializedName("created_at") var createdAt: String = "",
        @SerializedName("body") var body: String? = null,
        @SerializedName("url") var url: String = "",
        @SerializedName("comment_count") var commentCount: Int = 0,
        @SerializedName("love_count") var loveCount: Int = 0,
        @SerializedName("is_loved_by_me") var isLovedByMe: Boolean = false,
        @SerializedName("variants") var variants: PictureVariants
) {
    fun asEntity(): ContentEntity {
        val contentEntity = ContentEntity()
        contentEntity.networkId = id
        contentEntity.type = Content.TYPE.PICTURE.toString()
        contentEntity.pictureVariants = variants
        contentEntity.body = body
        contentEntity.url = url
        contentEntity.createdAt = createdAt
        contentEntity.loved = isLovedByMe
        contentEntity.commentCount = commentCount
        contentEntity.loveCount = loveCount
        contentEntity.hasNewComments = false
        return contentEntity
    }
}