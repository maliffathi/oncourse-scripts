records.each { CourseClass cc ->
	csv << [
			"code"                              : cc.code,
			"budgetedPlaces"                    : cc.budgetedPlaces,
			"createdOn"                         : cc.createdOn?.format("yyyy-MM-dd'T'HH:mm:ssZ"),
			"modifiedOn"                        : cc.modifiedOn?.format("yyyy-MM-dd'T'HH:mm:ssZ"),
			"deliveryMode"                      : cc.deliveryMode?.displayName,
			"startDateTime"                     : cc.startDateTime?.format("yyyy-MM-dd'T'HH:mm:ssZ", cc.timeZone),
			"endDateTime"                       : cc.endDateTime?.format("yyyy-MM-dd'T'HH:mm:ssZ", cc.timeZone),
			"isCancelled"                       : cc.isCancelled,
			"fundingSource"                     : cc.fundingSource?.displayName,
			"isDistantLearningCourse"           : cc.isDistantLearningCourse,
			"isWebVisible"                      : cc.isShownOnWeb,
			"maximumPlaces"                     : cc.maximumPlaces,
			"minimumPlaces"                     : cc.minimumPlaces,
			"notes"                             : cc.notes,
			"detBookingId"                      : cc.detBookingId,
			"message"                           : cc.message,
			"reportableHours"                   : cc.reportableHours?.format("0.00"),
			"priceAmount"                       : cc.feeIncGst?.toPlainString(),
			"priceTaxAmount"                    : cc.feeGST?.toPlainString(),
			"PriceTaxName"                      : cc.tax?.taxCode ?: "unknown",
			"roomName"                          : cc.room?.name,
			"roomSiteName"                      : cc.room?.site?.name,
			"roomSiteStreet"                    : cc.room?.site?.street,
			"roomSiteState"                     : cc.room?.site?.state,
			"roomSitePostcode"                  : cc.room?.site?.postcode,
			"roomSiteSuburb"                    : cc.room?.site?.suburb,
			"courseCode"                        : cc.course.code,
			"courseName"                        : cc.course.name,
			"courseCreatedOn"                   : cc.course.createdOn?.format("yyyy-MM-dd'T'HH:mm:ssZ"),
			"courseModifiedOn"                  : cc.course.modifiedOn?.format("yyyy-MM-dd'T'HH:mm:ssZ"),
			"courseCurrentlyOffered"            : cc.course.currentlyOffered,
			"courseFieldOfEducation"            : cc.course.fieldOfEducation,
			"courseIsWebVisible"                : cc.course.isShownOnWeb,
			"courseIsVET"                       : cc.course.isVET,
			"courseReportableHours"             : cc.course.reportableHours?.format("0.00"),
			"courseWebDescription"              : cc.course.webDescription,
			"courseAllowWaitingLists"           : cc.course.allowWaitingLists,
			"courseIsShownOnWeb"                : cc.course.isShownOnWeb,
			"courseIsSufficientForQualification": cc.course.isSufficientForQualification,
			"coursePrintedBrochureDescription"  : cc.course.printedBrochureDescription,
			"tutors"                            : cc.tutorRoles?.collect { tr -> tr.tutor.fullName }.join(", "),
			"enrolmentCount"                    : cc.validEnrolmentCount
	]
}
