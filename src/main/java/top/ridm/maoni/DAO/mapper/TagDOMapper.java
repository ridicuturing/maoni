package top.ridm.maoni.DAO.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import top.ridm.maoni.model.DO.TagDO;
import top.ridm.maoni.model.DO.TagDOExample;

public interface TagDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    long countByExample(TagDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int deleteByExample(TagDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int insert(TagDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int insertSelective(TagDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    List<TagDO> selectByExampleWithRowbounds(TagDOExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    List<TagDO> selectByExample(TagDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    TagDO selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int updateByExampleSelective(@Param("record") TagDO record, @Param("example") TagDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int updateByExample(@Param("record") TagDO record, @Param("example") TagDOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int updateByPrimaryKeySelective(TagDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tag
     *
     * @mbg.generated Wed Aug 28 17:45:44 CST 2019
     */
    int updateByPrimaryKey(TagDO record);
}