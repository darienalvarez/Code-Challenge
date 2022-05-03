package com.darienalvarez.codechallenge.domain.model.json

import com.darienalvarez.codechallenge.domain.api.adapter.JsonDateTime
import com.darienalvarez.codechallenge.domain.model.dto.Transaction
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
class TransactionJson(

    @Json(name = "Id")
    override val id: String,

    @Json(name = "AccountNumber")
    override val accountNumber: String,

    @Json(name = "IdType")
    override val idType: Long,

    @Json(name = "CommentCode")
    override val commentCode: Long,

    @Json(name = "TransferCode")
    override val transferCode: Long,

    @Json(name = "AdjustmentCode")
    override val adjustmentCode: Long,

    @Json(name = "RegECode")
    override val regECode: Long,

    @Json(name = "RegDCheckCode")
    override val regDCheckCode: Long,

    @Json(name = "RegDTransferCode")
    override val regDTransferCode: Long,

    @Json(name = "VoidCode")
    override val voidCode: Long,

    @Json(name = "SubActionCode")
    override val subActionCode: String,

    @Json(name = "SequenceNumber")
    override val sequenceNumber: Long,

    @Json(name = "EffectiveDate")
    @JsonDateTime
    override val effectiveDate: LocalDateTime,

    @Json(name = "PostDate")
    @JsonDateTime
    override val postDate: LocalDateTime,

    @Json(name = "PostTime")
    override val postTime: Long,

    @Json(name = "PreviousAvailableBalance")
    override val previousAvailableBalance: Double,

    @Json(name = "UserNumber")
    override val userNumber: Long,

    @Json(name = "UserOverride")
    override val userOverride: Long,

    @Json(name = "SecurityLevels")
    override val securityLevels: Long,

    @Json(name = "Description")
    override val description: String,

    @Json(name = "ActionCode")
    override val actionCode: String,

    @Json(name = "SourceCode")
    override val sourceCode: String,

    @Json(name = "BalanceChange")
    override val balanceChange: Double,

    @Json(name = "InterestPenalty")
    override val interestPenalty: Double,

    @Json(name = "NewBalance")
    override val newBalance: Double,

    @Json(name = "FeeAmount")
    override val feeAmount: Double,

    @Json(name = "EscrowAmount")
    override val escrowAmount: Double,

    @Json(name = "LastTranDate")
    @JsonDateTime
    override val lastTranDate: LocalDateTime,

    @Json(name = "MaturityLoanDueDate")
    @JsonDateTime
    override val maturityLoanDueDate: LocalDateTime? = null,

    @Json(name = "Comment")
    override val comment: String,

    @Json(name = "Branch")
    override val branch: Long,

    @Json(name = "ConsoleNumber")
    override val consoleNumber: Long,

    @Json(name = "BatchSequence")
    override val batchSequence: Long,

    @Json(name = "SalesTaxAmount")
    override val salesTaxAmount: Double,

    @Json(name = "ActivityDate")
    override val activityDate: String,

    @Json(name = "BilledFeeAmount")
    override val billedFeeAmount: Double,

    @Json(name = "ProcessorUser")
    override val processorUser: Long,

    @Json(name = "MemberBranch")
    override val memberBranch: String,

    @Json(name = "SubSourceCode")
    override val subSourceCode: Long,

    @Json(name = "ConfirmationSequence")
    override val confirmationSequence: Long,

    @Json(name = "MicrAccountNumber")
    override val micrAccountNumber: String,

    @Json(name = "MicrRtNumber")
    override val micrRtNumber: String,

    @Json(name = "Recurring")
    override val recurring: Long,

    @Json(name = "FeeExemptCourtesyAmount")
    override val feeExemptCourtesyAmount: Double,

    @Json(name = "BalSeg001SegmentId")
    override val balSeg001SegmentID: String,

    @Json(name = "InterestEffectiveDate")
    @JsonDateTime
    override val interestEffectiveDate: LocalDateTime? = null,

    @Json(name = "BalSeg001PmtChangeDate")
    @JsonDateTime
    override val balSeg001PmtChangeDate: LocalDateTime? = null,

    @Json(name = "BalSeg001PrevFirstPmtDate")
    @JsonDateTime
    override val balSeg001PrevFirstPmtDate: LocalDateTime? = null,

    @Json(name = "DraftNumber")
    override val draftNumber: String,

    @Json(name = "TracerNumber")
    override val tracerNumber: String,

    @Json(name = "SubSourceDescription")
    override val subSourceDescription: String,

    @Json(name = "TransactionAmount")
    override val transactionAmount: Double,

    @Json(name = "ConfirmationNumber")
    override val confirmationNumber: String

) : Transaction