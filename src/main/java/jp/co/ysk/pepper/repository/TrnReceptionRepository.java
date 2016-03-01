package jp.co.ysk.pepper.repository;

import java.util.List;

import jp.co.ysk.pepper.entity.TrnReception;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
// JpaRepository ジェネリクスの第一引数にエンティティクラス、第二引数に主キーのフィールド型
public interface TrnReceptionRepository  extends JpaRepository<TrnReception, Integer>, JpaSpecificationExecutor<TrnReception> {

    @Query("select t from TrnReception t where t.windowId.windowId = :windowId")
    List<TrnReception> selectByWindowId(@Param("windowId") String windowId);

    @Query("select t from TrnReception t where t.displayId = :displayId")
    TrnReception selectByDisplayId(@Param("displayId") Integer displayId);

}