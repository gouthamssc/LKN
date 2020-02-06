package com.ibm.fms.bim.Joins

import java.sql.Date

import com.ibm.fms.bim.{SparkSessionTestWrapper, TestHelperFunctions}
import org.apache.spark.sql.types.{DataTypes, DateType, DoubleType, IntegerType, LongType, StringType, StructField, StructType, TimestampType}
import org.scalatest.FunSuite

class CLTTest extends FunSuite  with SparkSessionTestWrapper {
//  4.JoinTargetAccountWithValidCoveref
  test("check whether the  joinTargetAccountWithValidCoveref  returns the expected Schema")
  {
    val testHelperFunctions = new TestHelperFunctions()
    val CLTTest = new CLT()
    val nullableBoolean = true;

    val expectedSchema = StructType(Seq(
      StructField("TITT_COVREF_ID", LongType, nullableBoolean)
      ,StructField("TARGET_ACCOUNT_ID",LongType, nullableBoolean)
      ,StructField("TARGET_ACCT_CD",StringType, nullableBoolean)
      ,StructField("SUBMARKET_ID",LongType, nullableBoolean)

      ,StructField("CUSTOMER_SET_ID",LongType, nullableBoolean)
      ,StructField("IMT_ID",LongType, nullableBoolean)
      ,StructField("CUST_SET_NAME",StringType, nullableBoolean)
      ,StructField("IOT_ID",LongType, nullableBoolean)

      ,StructField("TIMT_NAME",StringType, nullableBoolean)
      ,StructField("IMT_CD",StringType, nullableBoolean)
      ,StructField("ORIG_SUBMARKET_ID",LongType, nullableBoolean)
      ,StructField("SUBMARKET_CD",StringType, nullableBoolean)
      ,StructField("SUBMARKET_NAME",StringType, nullableBoolean)


    )
    )
    val EFFC_DATE_STRING = "2020-01-01"
    val EFFC_DATE_SQL = Date.valueOf(EFFC_DATE_STRING)

    val expectedDataFrame = testHelperFunctions.createEmptyDataFrameWithGivenSchema(spark, expectedSchema)
    val actualDataFrame =  CLTTest.joinTargetAccountWithValidCoveref( EFFC_DATE_SQL,0)
    assert(testHelperFunctions.assertDataFrameColumnCountEquals(expectedDataFrame, actualDataFrame))

  }

  //5.joinValidTargetAccountIDwithALT
  test("check whether the joinValidTargetAccountIDwithALT returns the expected Schema")
  {
    val testHelperFunctions = new TestHelperFunctions()
    val CLTTest = new CLT()
    val nullableBoolean = true;

    val expectedSchema = StructType(Seq(

      StructField("TARGET_ACCOUNT_ID",LongType, nullableBoolean)
      ,StructField("IMT_ID",LongType, nullableBoolean)
      ,StructField("SUBMARKET_ID",LongType, nullableBoolean)
      ,StructField("CUSTOMER_SET_ID",LongType, nullableBoolean)
      ,StructField("CUST_SET_NAME",StringType, nullableBoolean)
      ,StructField("IOT_ID",LongType, nullableBoolean)
      ,StructField("IMT_NAME",StringType, nullableBoolean)
      ,StructField("IMT_CD",StringType, nullableBoolean)
      ,StructField("ORIG_SUBMARKET_ID",LongType, nullableBoolean)
      ,StructField("SUBMARKET_CD",StringType, nullableBoolean)
      ,StructField("SUBMARKET_NAME",StringType, nullableBoolean)
      ,StructField("ACCOUNT_LVL_TARGET_ID",LongType, nullableBoolean)
      ,StructField("BRAND_SUB_SUBGROUP_ID",LongType, nullableBoolean)
      ,StructField("ITT_ATTRIB_VALUE_ID_TGT",LongType, nullableBoolean)
      ,StructField("TARGET_AMOUNT",DataTypes.createDecimalType(31,10), nullableBoolean)
      ,StructField("GP_TARGET_AMOUNT",DataTypes.createDecimalType(31,10), nullableBoolean)
      ,StructField("ADJ_TARGET_AMOUNT",DataTypes.createDecimalType(31,10), nullableBoolean)
      ,StructField("ADJ_GP_TARGET_AMOUNT",DataTypes.createDecimalType(31,10), nullableBoolean)
      ,StructField("TARGET_SKEW_PCT",DataTypes.createDecimalType(11,10), nullableBoolean)
      ,StructField("REASON_CD",StringType, nullableBoolean)
      ,StructField("EFFC_DATE",DateType, nullableBoolean)
      ,StructField("DLET_DATE",DateType, nullableBoolean)
      ,StructField("LAST_ACT_SYS_CD",StringType, nullableBoolean)
      ,StructField("GT10_TARGET_AMOUNT",DataTypes.createDecimalType(31,10), nullableBoolean)
      ,StructField("LT10_TARGET_AMOUNT",DataTypes.createDecimalType(31,10), nullableBoolean)
      ,StructField("ADJ_CLOUD_TARGET_AMOUNT",DataTypes.createDecimalType(31,10), nullableBoolean)




    )
    )
    val EFFC_DATE_STRING = "2020-01-01"
    val EFFC_DATE_SQL = Date.valueOf(EFFC_DATE_STRING)


    val expectedDataFrame = testHelperFunctions.createEmptyDataFrameWithGivenSchema(spark, expectedSchema)
    val actualDataFrame =  CLTTest.joinValidTargetAccountIDwithALT(EFFC_DATE_SQL,0)
    assert(testHelperFunctions.assertDataFrameColumnCountEquals(expectedDataFrame, actualDataFrame))

  }


//7.joinCustwithTargetAccountCMRMapping
  test("check whether the joinCustwithTargetAccountCMRMapping returns the expected Schema")
  {
    val testHelperFunctions = new TestHelperFunctions()
    val CLTTest = new CLT()
    val nullableBoolean = true;

    val expectedSchema = StructType(Seq(

      StructField("TARGET_ACCOUNT_ID",LongType, nullableBoolean)
      ,StructField("CUST_ACCT_PCT",DoubleType, nullableBoolean)
      ,StructField("ITT_CUST_ID",LongType, nullableBoolean)



    )
    )



    val expectedDataFrame = testHelperFunctions.createEmptyDataFrameWithGivenSchema(spark, expectedSchema)
    val actualDataFrame =  CLTTest.joinCustwithTargetAccountCMRMapping(0)
    assert(testHelperFunctions.assertDataFrameColumnCountEquals(expectedDataFrame, actualDataFrame))

  }


}
