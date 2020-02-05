package com.ibm.fms.bim

import com.ibm.fms.bim.dbread.AttributeValue
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import org.scalatest.FunSuite

class UtilityTest extends FunSuite with SparkSessionTestWrapper {
  test("Column count of get Attrib value function is returning as expected without cast parameter passed"){
    val testHelperFunctions = new TestHelperFunctions()
    val attribValue = new AttributeValue()
    val nullableBoolean=true
    val expectedSchema = StructType(Seq(StructField("ITT_ATTRIB_VALUE_ID", StringType, nullableBoolean)
//      ,StructField("lastName", IntegerType, true),StructField("middleName", IntegerType, true)
      )
    )
    val expectedDataFrame = testHelperFunctions.createEmptyDataFrameWithGivenSchema(spark,expectedSchema)
    val actualDataFrame = attribValue.getAttributeValueToDF("ITT_ATTRIB_VALUE_ID","ATTRIB_VALUE_CD","AMRE")

    assert(testHelperFunctions.assertDataFrameColumnCountEquals(expectedDataFrame,actualDataFrame))
  }
  test("Column count of get Attrib value function is returning as expected with cast parameter passed"){
    val testHelperFunctions = new TestHelperFunctions()
    val attribValue = new AttributeValue()
    val castParameter = "int"
    val nullableBoolean=true

    val expectedSchema = StructType(Seq(StructField("ITT_ATTRIB_VALUE_ID", IntegerType, nullableBoolean)
      //      ,StructField("lastName", IntegerType, true),StructField("middleName", IntegerType, true)
    )
    )
    val expectedDataFrame = testHelperFunctions.createEmptyDataFrameWithGivenSchema(spark,expectedSchema)
    val actualDataFrame = attribValue.getAttributeValueToDF("ITT_ATTRIB_VALUE_ID","ATTRIB_VALUE_CD","AMRE",castParameter)

    assert(testHelperFunctions.assertDataFrameColumnCountEquals(expectedDataFrame,actualDataFrame))
  }
//  test("output count for each market should match with corresponding TargerAcctCmrMapping"){
//    val databaseread = new DatabaseRead()
//    val DFaccountChangeSnapshot = accountChangeSnapshot.accountChangeSnapshotRead()
//    val expectedDF = DFaccountChangeSnapshot.select("SNAP_IMT_ID").groupBy("SNAP_IMT_ID").count().withColumnRenamed("SNAP_IMT_ID","IMT_ID")
//    val DF_TARGET_ACCT_CMR_MAPPING = databaseread.runQuery("FMST_O_ITT_TARGET_ACCT_CMR_MAPPING")
//    val actualDF = DF_TARGET_ACCT_CMR_MAPPING.select("IMT_ID").groupBy("IMT_ID").count()
////    assert(assertDataFrameEquals(actualDF,expectedDF))
//  }
}