package top.ridm.maoni.model.DO;

import java.sql.Date;

public class TagDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    private String tag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.user_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.create_time
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tag.update_time
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.id
     *
     * @return the value of tag.id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.id
     *
     * @param id the value for tag.id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.tag
     *
     * @return the value of tag.tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.tag
     *
     * @param tag the value for tag.tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.user_id
     *
     * @return the value of tag.user_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.user_id
     *
     * @param userId the value for tag.user_id
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.create_time
     *
     * @return the value of tag.create_time
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.create_time
     *
     * @param createTime the value for tag.create_time
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tag.update_time
     *
     * @return the value of tag.update_time
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tag.update_time
     *
     * @param updateTime the value for tag.update_time
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}