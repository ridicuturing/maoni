package top.ridm.maoni.model.DO;

public class PostTagDOKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post_tag.post_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    private Integer postId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column post_tag.tag_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    private Integer tagId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post_tag.post_id
     *
     * @return the value of post_tag.post_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post_tag.post_id
     *
     * @param postId the value for post_tag.post_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column post_tag.tag_id
     *
     * @return the value of post_tag.tag_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column post_tag.tag_id
     *
     * @param tagId the value for post_tag.tag_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}