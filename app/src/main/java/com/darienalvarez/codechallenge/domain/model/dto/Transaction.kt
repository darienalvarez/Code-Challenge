package com.darienalvarez.codechallenge.domain.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.text.NumberFormat
import java.time.LocalDateTime
import java.util.*

/**
 * Represents a Transaction
 */
interface Transaction {

    val id: String

    val accountNumber: String

    val idType: Long

    val commentCode: Long

    val transferCode: Long

    val adjustmentCode: Long

    val regECode: Long

    val regDCheckCode: Long

    val regDTransferCode: Long

    val voidCode: Long

    val subActionCode: String

    val sequenceNumber: Long

    val effectiveDate: LocalDateTime

    val postDate: LocalDateTime

    val postTime: Long

    val previousAvailableBalance: Double

    val userNumber: Long

    val userOverride: Long

    val securityLevels: Long

    val description: String

    val actionCode: String

    val sourceCode: String

    val balanceChange: Double

    val interestPenalty: Double

    val newBalance: Double

    val feeAmount: Double

    val escrowAmount: Double

    val lastTranDate: LocalDateTime

    val maturityLoanDueDate: LocalDateTime?

    val comment: String

    val branch: Long

    val consoleNumber: Long

    val batchSequence: Long

    val salesTaxAmount: Double

    val activityDate: String

    val billedFeeAmount: Double

    val processorUser: Long

    val memberBranch: String

    val subSourceCode: Long

    val confirmationSequence: Long

    val micrAccountNumber: String

    val micrRtNumber: String

    val recurring: Long

    val feeExemptCourtesyAmount: Double

    val balSeg001SegmentID: String

    val balSeg001PmtChangeDate: LocalDateTime?

    val interestEffectiveDate: LocalDateTime?

    val balSeg001PrevFirstPmtDate: LocalDateTime?

    val draftNumber: String

    val tracerNumber: String

    val subSourceDescription: String

    val transactionAmount: Double

    val confirmationNumber: String

}

@Parcelize
data class TransactionDto(
    override val id: String,
    override val accountNumber: String,
    override val idType: Long,
    override val commentCode: Long,
    override val transferCode: Long,
    override val adjustmentCode: Long,
    override val regECode: Long,
    override val regDCheckCode: Long,
    override val regDTransferCode: Long,
    override val voidCode: Long,
    override val subActionCode: String,
    override val sequenceNumber: Long,
    override val effectiveDate: LocalDateTime,
    override val postDate: LocalDateTime,
    override val postTime: Long,
    override val previousAvailableBalance: Double,
    override val userNumber: Long,
    override val userOverride: Long,
    override val securityLevels: Long,
    override val description: String,
    override val actionCode: String,
    override val sourceCode: String,
    override val balanceChange: Double,
    override val interestPenalty: Double,
    override val newBalance: Double,
    override val feeAmount: Double,
    override val escrowAmount: Double,
    override val lastTranDate: LocalDateTime,
    override val maturityLoanDueDate: LocalDateTime?,
    override val comment: String,
    override val branch: Long,
    override val consoleNumber: Long,
    override val batchSequence: Long,
    override val salesTaxAmount: Double,
    override val activityDate: String,
    override val billedFeeAmount: Double,
    override val processorUser: Long,
    override val memberBranch: String,
    override val subSourceCode: Long,
    override val confirmationSequence: Long,
    override val micrAccountNumber: String,
    override val micrRtNumber: String,
    override val recurring: Long,
    override val feeExemptCourtesyAmount: Double,
    override val balSeg001SegmentID: String,
    override val balSeg001PmtChangeDate: LocalDateTime?,
    override val interestEffectiveDate: LocalDateTime?,
    override val balSeg001PrevFirstPmtDate: LocalDateTime?,
    override val draftNumber: String,
    override val tracerNumber: String,
    override val subSourceDescription: String,
    override val transactionAmount: Double,
    override val confirmationNumber: String

) : Transaction, Parcelable {

    companion object {

        fun fromTransaction(transaction: Transaction): TransactionDto =
            TransactionDto(
                id = transaction.id,
                accountNumber = transaction.accountNumber,
                idType = transaction.idType,
                commentCode = transaction.commentCode,
                transferCode = transaction.transferCode,
                adjustmentCode = transaction.adjustmentCode,
                regECode = transaction.regECode,
                regDCheckCode = transaction.regDCheckCode,
                regDTransferCode = transaction.regDTransferCode,
                voidCode = transaction.voidCode,
                subActionCode = transaction.subActionCode,
                sequenceNumber = transaction.sequenceNumber,
                effectiveDate = transaction.effectiveDate,
                postDate = transaction.postDate,
                postTime = transaction.postTime,
                previousAvailableBalance = transaction.previousAvailableBalance,
                userNumber = transaction.userNumber,
                userOverride = transaction.userOverride,
                securityLevels = transaction.securityLevels,
                description = transaction.description,
                actionCode = transaction.actionCode,
                sourceCode = transaction.sourceCode,
                balanceChange = transaction.balanceChange,
                interestPenalty = transaction.interestPenalty,
                newBalance = transaction.newBalance,
                feeAmount = transaction.feeAmount,
                escrowAmount = transaction.escrowAmount,
                lastTranDate = transaction.lastTranDate,
                maturityLoanDueDate = transaction.maturityLoanDueDate,
                comment = transaction.comment,
                branch = transaction.branch,
                consoleNumber = transaction.consoleNumber,
                batchSequence = transaction.batchSequence,
                salesTaxAmount = transaction.salesTaxAmount,
                activityDate = transaction.activityDate,
                billedFeeAmount = transaction.billedFeeAmount,
                processorUser = transaction.processorUser,
                memberBranch = transaction.memberBranch,
                subSourceCode = transaction.subSourceCode,
                confirmationSequence = transaction.confirmationSequence,
                micrAccountNumber = transaction.micrAccountNumber,
                micrRtNumber = transaction.micrRtNumber,
                recurring = transaction.recurring,
                feeExemptCourtesyAmount = transaction.feeExemptCourtesyAmount,
                balSeg001SegmentID = transaction.balSeg001SegmentID,
                balSeg001PmtChangeDate = transaction.balSeg001PmtChangeDate,
                interestEffectiveDate = transaction.interestEffectiveDate,
                balSeg001PrevFirstPmtDate = transaction.balSeg001PrevFirstPmtDate,
                draftNumber = transaction.draftNumber,
                tracerNumber = transaction.tracerNumber,
                subSourceDescription = transaction.subSourceDescription,
                transactionAmount = transaction.transactionAmount,
                confirmationNumber = transaction.confirmationNumber
            )

    }
}