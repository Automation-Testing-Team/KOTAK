package COM.KOTAK.QA.PAGES;

import java.io.IOException;
//imports
import java.util.List;
import java.util.Map;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import COM.KOTAK.QA.UTIL.ElementUtil;
import COM.KOTAK.QA.UTIL.FileReadUtils;
import cucumber.api.java.et.Eeldades;

public class ProfilePage {

	/**
	 * @Author -- Yashashree Suryawanshi
	 * @version 1.0
	 * @since 26-11-2021
	 * 
	 * <h2>Class Description : Class Involving different methods related to Administration->Profile Menu</h2>
	 **/

	List<Map<String, String>> test_Data;
	ElementUtil elementUtil;
	FileReadUtils fileReader;
	HomePage homePage;
	private WebDriver driver;
	Logger log = Logger.getLogger(ProfilePage.class);

	@FindBy(xpath = "//input[@value='OK']")
	WebElement okBtn;

	@FindBy(xpath = "//input[@value='OK']")
	WebElement confirmOK;

	@FindBy(name = "org.apache.struts.taglib.html.CANCEL")
	WebElement btnCancel;

	@FindBy(id = "checkAllBtn")
	WebElement btnChkAll;

	@FindBy(id = "unCheckAllBtn")
	WebElement btnUnChkAll;

	@FindBy(xpath = "//p[@class='errormessages']")
	WebElement errormessages;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement btnReset;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/p[1]")
	WebElement btnOkErrorMsg;

	@FindBy(xpath = "//a[normalize-space()='Restart Workflow']")
	WebElement restartWorkFlowBtn;

	@FindBy(xpath = "//input[@value='Reset']")
	WebElement resetBtn;

	@FindBy(name = "name")
	WebElement profileNameTxtField;

	@FindBy(name="profileName")
	WebElement filterScreenProfileNameTxtField;

	@FindBy(name="profileDesc")
	WebElement profileDescTxtField;

	@FindBy(xpath="//*[@id=\"pageBody\"]/p[1]")
	WebElement validationmsg;
	
	@FindBy(xpath = "//p[@class='label']")
	WebElement validateFilterMsg;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement record;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[4]")
	WebElement nextStatus;

	@FindBy(name = "profileName")
	WebElement nameField;

	@FindBy(name = "filter")
	WebElement statusDropdown;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement btnSubmit;

	@FindBy(name = "approve")
	WebElement approveBtn;

	@FindBy(name = "reject")
	WebElement rejectBtn;

	@FindBy(name = "repair")
	WebElement toRepairBtn;

	@FindBy(xpath = "//input[@value=\"Cancel\"]")
	WebElement btnCancel2;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement modifyRecord;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement verifyProfilename;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[3]")
	WebElement verifyProfilenameStatus;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]")
	WebElement approveScreenRecord;
	
	// Xpath for CheckBoxes
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@PasswordChangeStart']")
	WebElement passwordCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@LogOut']")
	WebElement logoutCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@LogDBView']")
	WebElement logViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/SecurityParamsAction.do?method=view']")
	WebElement securityParametersViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/SecurityParamsAction.do?method=modify']")
	WebElement securityParametersModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/SecurityParamsAction.do?method=approve']")
	WebElement securityParametersApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/user/UseLis']")
	WebElement userViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/user/UseAdd']")
	WebElement userAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/user/UseModLis?filterAction=UseMod']")
	WebElement userModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/user/UseAppLis?filterAction=UseApp']")
	WebElement userApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/user/UseBlkLis?filterAction=UseBlk']")
	WebElement userBlockUnblockCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/user/UseDelLis?filterAction=UseDel']")
	WebElement userRemoveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/user/AdminReportAction?method=viewUserReport']")
	WebElement userReportViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/GroupPreList']")
	WebElement groupListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/GroupAdd']")
	WebElement groupAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/GroupModifyList']")
	WebElement groupModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/GroupApproveList']")
	WebElement groupApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/GroupBlockList']")
	WebElement groupBlockCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/GroupUnblock']")
	WebElement groupUnblockCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/GroupRemoveList']")
	WebElement groupRemoveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/AdminReportAction?method=generateGroupReport']")
	WebElement groupReportBuildCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/group/AdminReportAction?method=viewGroupReport']")
	WebElement groupReportViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/profile/ProfLis']")
	WebElement profilesListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/profile/ProfCre']")
	WebElement profilesAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/profile/ProfModLis']")
	WebElement profilesModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/profile/ProfAppLis']")
	WebElement profilesApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/profile/ProfDelLis']")
	WebElement profilesRemoveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/profile/AdminReportAction?method=generateProfileReport']")
	WebElement profilesReportBuildCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@main/profile/AdminReportAction?method=viewProfileReport']")
	WebElement profilesReportViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/loginMatrix/LoginMatrixListFilter']")
	WebElement loginMatrixListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/loginMatrix/LoginMatrixAdd']")
	WebElement loginMatrixAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/loginMatrix/LoginMatrixModifyListFilter']")
	WebElement loginMatrixModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/loginMatrix/LoginMatrixDeleteFilter']")
	WebElement loginMatrixDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/RemoteResourceAction.do?method=remoteRun&metaFilter=RESOURCE_FILTER{dep_filter|FIRST.HAS.CAPTION=true}']")
	WebElement environmentGlobalProcessesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/ResourceAction.do?method=run&metaFilter=RESOURCE_FILTER{res_filter|FIRST.HAS.CAPTION=true}']")
	WebElement environmentRunCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/ResourceAction.do?method=show&metaFilter=RESOURCE_FILTER{res_filter|FIRST.HAS.CAPTION=true}']")
	WebElement environmentShowCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/CalLis']")
	WebElement calendarViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/CalCre']")
	WebElement calendarCreateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/CalMod']")
	WebElement calendarModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/CalApp']")
	WebElement calendarApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/certMaint/CertMaintList']")
	WebElement certificateListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/certMaint/CertMaintAdd']")
	WebElement certificateAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/certMaint/CertMaintModify']")
	WebElement certificateModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/certMaint/CertMaintDelete']")
	WebElement certificateDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/npcicertMaint/npcicertMaintList']")
	WebElement npciCertificateListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/npcicertMaint/npcicertMaintAdd']")
	WebElement npciCertificateAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/npcicertMaint/npcicertMaintModify']")
	WebElement npciCertificateModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/npcicertMaint/npcicertMaintDelete']")
	WebElement npciCertificateDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateCustomer/CorporateCustomerList']")
	WebElement customerListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateCustomer/CorporateCustomerAdd']")
	WebElement customerAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateCustomer/CorporateCustomerApprove']")
	WebElement customerApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateCustomer/CorporateCustomerModify']")
	WebElement customerModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateCustomer/CorporateCustomerDelete']")
	WebElement customerDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateCustomer/CorporateCustomerDelConf']")
	WebElement customerConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateCustomer/CustomerMappingFilter']")
	WebElement customerSchemeFormatCodeMappingCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/CorporateSchemeList']")
	WebElement schemeListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/CorporateSchemeAdd']")
	WebElement schemeAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/CorporateSchemeApprove']")
	WebElement schemeApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/CorporateSchemeModify']")
	WebElement schemeModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/CorporateSchemeDelete']")
	WebElement schemeDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/CorporateSchemeDelConf']")
	WebElement schemeConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/UploadFile']")
	WebElement schemeUploadCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateScheme/LoadDownloadForm']")
	WebElement schemeDownloadCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRM/CorpRMFilter']")
	WebElement relationshipManagerListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRM/CorpRMAdd']")
	WebElement relationshipManagerAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRM/CorporateRMApprove']")
	WebElement relationshipManagerApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRM/CorporateRMModify']")
	WebElement relationshipManagerModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRM/CorporateRMDelete']")
	WebElement relationshipManagerDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRM/CorporateRMDelConf']")
	WebElement relationshipManagerConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateMisc/CorporateMiscList']")
	WebElement miscellaneousListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateMisc/CorporateMiscAdd']")
	WebElement miscellaneousAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateMisc/CorporateMiscApprove']")
	WebElement miscellaneousApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateMisc/CorporateMiscModify']")
	WebElement miscellaneousModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateMisc/CorporateMiscDelete']")
	WebElement miscellaneousDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateMisc/CorporateMiscDelConf']")
	WebElement miscellaneousConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAccounting/CorporateAccountingFilter']")
	WebElement accountingListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAccounting/CorporateAccountingAdd']")
	WebElement accountingAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAccounting/CorporateAccountingApprove']")
	WebElement accountingApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAccounting/CorporateAccountingModify']")
	WebElement accountingModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAccounting/CorporateAccountingDelete']")
	WebElement accountingDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAccounting/CorporateAccountingDelConf']")
	WebElement accountingConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAuthorizationMatrix/CorporateAuthorizationMatrixFilter']")
	WebElement authorizationListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAuthorizationMatrix/CorporateAuthorizationMatrixAdd']")
	WebElement authorizationAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAuthorizationMatrix/CorporateAuthorizationMatrixApprove']")
	WebElement authorizationApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAuthorizationMatrix/CorporateAuthorizationMatrixModify']")
	WebElement authorizationModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAuthorizationMatrix/CorporateAuthorizationMatrixDelete']")
	WebElement authorizationDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateAuthorizationMatrix/CorporateAuthorizationMatrixDelConf']")
	WebElement authorizationConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateNotification/CorpNotificationFilter']")
	WebElement alertandNotificationListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateNotification/CorpNotificationAdd']")
	WebElement alertandNotificationAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateNotification/CorpNotificationApprove']")
	WebElement alertandNotificationApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateNotification/CorpNotificationModify']")
	WebElement alertandNotificationModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateNotification/CorpNotificationDelete']")
	WebElement alertandNotificationDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateNotification/CorpNotificationDelConf']")
	WebElement alertandNotificationConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateModeOfOperation/CorpModeOfOperationFilter']")
	WebElement modeOfOperationListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateModeOfOperation/CorpModeOfOperationAdd']")
	WebElement modeOfOperationAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateModeOfOperation/CorpModeOfOperationApprove']")
	WebElement modeOfOperationApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateModeOfOperation/CorpModeOfOperationModify']")
	WebElement modeOfOperationModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateModeOfOperation/CorpModeOfOperationDelete']")
	WebElement modeOfOperationDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateModeOfOperation/CorpModeOfOperationDelConf']")
	WebElement modeOfOperationConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateIndustryType/CorpIndustryTypeFilter']")
	WebElement industryTypeListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateIndustryType/CorpIndustryTypeAdd']")
	WebElement industryTypeAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateIndustryType/CorpIndustryTypeApprove']")
	WebElement industryTypeApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateIndustryType/CorpIndustryTypeModify']")
	WebElement industryTypeModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateIndustryType/CorpIndustryTypeDelete']")
	WebElement industryTypeDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateIndustryType/CorpIndustryTypeDelConf']")
	WebElement industryTypeConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateBusinessGroup/CorporateBusinessGroupList']")
	WebElement businessGroupListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateBusinessGroup/CorporateBusinessGroupAdd']")
	WebElement businessGroupAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateBusinessGroup/CorporateBusinessGroupApprove']")
	WebElement businessGroupApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateBusinessGroup/CorporateBusinessGroupModify']")
	WebElement businessGroupModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateBusinessGroup/CorporateBusinessGroupDelete']")
	WebElement businessGroupDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateBusinessGroup/CorporateBusinessGroupDelConf']")
	WebElement businessGroupConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateDuplicateCheck/duplicateCheckList']")
	WebElement duplicateCheckListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateDuplicateCheck/duplicateCheckAdd']")
	WebElement duplicateCheckAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateDuplicateCheck/duplicateCheckApprove']")
	WebElement duplicateCheckApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateDuplicateCheck/duplicateCheckModify']")
	WebElement duplicateCheckModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateDuplicateCheck/duplicateCheckDelete']")
	WebElement duplicateCheckDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateDuplicateCheck/duplicateCheckDelConf']")
	WebElement duplicateCheckConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRepMapping/CorporateRepMappingList']")
	WebElement representMappingListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRepMapping/CorporateRepMappingAdd']")
	WebElement representMappingAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRepMapping/CorporateRepMappingApprove']")
	WebElement representMappingApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRepMapping/CorporateRepMappingModify']")
	WebElement representMappingModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRepMapping/CorporateRepMappingDelete']")
	WebElement representMappingDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateRepMapping/CorporateRepMappingDelConf']")
	WebElement representMappingConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateVendor/CorporateVendorList']")
	WebElement vendorListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateVendor/CorporateVendorAdd']")
	WebElement vendorAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateVendor/CorporateVendorApprove']")
	WebElement vendorApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateVendor/CorporateVendorModify']")
	WebElement vendorModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateVendor/CorporateVendorDelete']")
	WebElement vendorDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateVendor/CorporateVendorDelConf']")
	WebElement vendorConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/cms/corporateModule/corporateVendor/VendorMappingFilter']")
	WebElement vendorSchemeFormatCodeMappingCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateCharge/ChargeList?method=filter']")
	WebElement chargeListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateCharge/ChargeAdd?method=filter']")
	WebElement chargeAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateCharge/ChargeApprove?method=filter']")
	WebElement chargeApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateCharge/ChargeModify?method=filter']")
	WebElement chargeModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateCharge/ChargeDelete?method=filter']")
	WebElement chargeDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateCharge/ChargeDeleteConf?method=filter']")
	WebElement chargeConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateChargePosting/ChargePostingList?method=filter']")
	WebElement corporateChargePostingListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateChargePosting/ChargePostingAdd?method=filter']")
	WebElement corporateChargePostingAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateChargePosting/ChargePostingModify?method=filter']")
	WebElement corporateChargePostingModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateChargePosting/GenerateReport?method=filter']")
	WebElement corporateChargePostingGenerateReportCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/corporateModule/corporateChargePosting/ChargePosting?method=filter']")
	WebElement corporateChargePostingChargePostingCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/IfscCodeList']")
	WebElement ifscCodeListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/IfscCodeAdd']")
	WebElement ifscCodeAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/IfscCodeApprove']")
	WebElement ifscCodeApproveCheckbox;

	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/IfscCodeModify']")
	WebElement ifscCodeModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/IfscCodeDelete']")
	WebElement ifscCodeDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/IfscCodeDelConf']")
	WebElement ifscCodeConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/NPCICodesMaint']")
	WebElement npciCodesMaintainNPCICodesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/NPCICodesList']")
	WebElement npciCodesListNPCICodesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/db/CifDbLoad']")
	WebElement dbLoadsCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ifscSubMem/IFSCSubMem?operation=0']")
	WebElement subMemberIFSCCODEUploadCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ifscSubMem/IfscSubMemCodeList']")
	WebElement subMemberIFSCCODEListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ifscSubMem/IfscSubMemCodeAdd']")
	WebElement subMemberIFSCCODEAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ifscSubMem/IfscSubMemCodeApprove']")
	WebElement subMemberIFSCCODEApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ifscSubMem/IfscSubMemCodeModify']")
	WebElement subMemberIFSCCODEModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ifscSubMem/IfscSubMemCodeDelete']")
	WebElement subMemberIFSCCODEDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ifscSubMem/IfscSubMemCodeDelConf']")
	WebElement subMemberIFSCCODEConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/InstallParamMaint']")
	WebElement parameterMaintenanceCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/EmailList.do&metaFilter=EMAIL_FILTER{set_filter_all|FIRST.HAS.CAPTION=true}']")
	WebElement distributionSetsListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/EmailNew.do&metaFilter=EMAIL_FILTER{set_filter|FIRST.HAS.CAPTION=true}']")
	WebElement distributionSetsAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/EmailSeqApprove.do?method=startSeqApprove']")
	WebElement distributionSetsApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/EmailModify.do&metaFilter=EMAIL_FILTER{set_filter_all|FIRST.HAS.CAPTION=true}']")
	WebElement distributionSetsModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/EmailDelete.do&metaFilter=EMAIL_FILTER{set_filter_all|FIRST.HAS.CAPTION=true}']")
	WebElement distributionSetsDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/EmailMessageList.do&metaFilter=EMAIL_FILTER{set_filter_all|CALENDAR|email_message_status_filter_all|FIRST.HAS.CAPTION=true}']")
	WebElement messagesViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@Synchro?forward=/EmailMessageNew.do&metaFilter=EMAIL_FILTER{email_enter_filter|FIRST.HAS.CAPTION=true}']")
	WebElement messagesNewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@SchedFilterAction']")
	WebElement scheduleListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@SchedAddFilterAction']")
	WebElement scheduleNewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@SchedModFilterAction']")
	WebElement scheduleModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@SchedulerRun?method=show']")
	WebElement scheduleControlCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/sftpParam/SftpParamList']")
	WebElement ftpsftpParametersListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/sftpParam/SftpParamNew']")
	WebElement ftpsftpParametersAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/sftpParam/SftpParamModify']")
	WebElement ftpsftpParametersModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/sftpParam/SftpParamFileListFilter']")
	WebElement ftpsftpParametersFTPSFTPFileListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/FAQMaint']")
	WebElement faqMaintainFAQCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/FAQList']")
	WebElement faqListFAQCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/sessionMaintenance/SessionMaintListFilter']")
	WebElement sessionMaintenanceListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/sessionMaintenance/SessionMaintAddFilter']")
	WebElement sessionMaintenanceAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/sessionMaintenance/SessionMaintModifyList']")
	WebElement sessionMaintenanceModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/sessionMaintenance/SessionMaintDeleteList']")
	WebElement sessionMaintenanceDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nameMatchingMaintainance/NMMaintListFilter']")
	WebElement nameMatchingListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nameMatchingMaintainance/NMMaintAddFilter']")
	WebElement nameMatchingAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nameMatchingMaintainance/NMMaintModifyList']")
	WebElement nameMatchingModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nameMatchingMaintainance/NMMaintDeleteList']")
	WebElement nameMatchingDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/scheduler/ReportSchedulerDispList']")
	WebElement corporateListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/scheduler/ReportSchedulerAdd']")
	WebElement corporateAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/scheduler/ReportSchedulerModifyList']")
	WebElement corporateModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/scheduler/ReportSchedulerDelList']")
	WebElement corporateDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/gfp/maintenance/GenericFileParserListFilter']")
	WebElement freeFormatCodeListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/gfp/maintenance/GenericFileParserAddFilter']")
	WebElement freeFormatCodeAddCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/gfp/maintenance/GenericFileParserCopyFilter']")
	WebElement freeFormatCodeCopyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/gfp/maintenance/GenericFileParserApproveFilter']")
	WebElement freeFormatCodeApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/gfp/maintenance/GenericFileParserModifyFilter']")
	WebElement freeFormatCodeModifyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/gfp/maintenance/GenericFileParserDeleteFilter']")
	WebElement freeFormatCodeDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/gfp/maintenance/GenericFileParserDeleteConfirmFilter']")
	WebElement freeFormatCodeConfirmDeleteCheckbox;
	
	@FindBy(xpath = "//tbody/tr[251]/td[7]/input[1]")
	WebElement fileManagerListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/FileManagerApprovePosting']")
	WebElement fileManagerApprovePostingFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/FileManagerCreate']")
	WebElement sponsorModuleCreateACHFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/FileManagerAccept']")
	WebElement sponsorModuleAcceptCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/UploadNachFile']")
	WebElement sponsorModuleUploadCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/uploadAPBSFile1']")
	WebElement sponsorModuleUploadAPBSFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/RejectFutureFilter']")
	WebElement sponsorModuleRejectFutureFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/FileManagerRepost']")
	WebElement sponsorModuleRepostCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/FileManagerPossibleRejectFilter']")
	WebElement sponsorModuleApprovePossibleRejectCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/FileManagerExportMis']")
	WebElement sponsorModuleExportMisCheckbox;
	
	@FindBy(xpath = "//tbody/tr[263]/td[7]/input[1]")
	WebElement destinationModuleCreateReturnACHFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/uploadOldMapper1']")
	WebElement destinationModuleUploadOldNewAccountMapperCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/InwardDebitRepostPosting/RepostDebitInwardFilter']")
	WebElement destinationModuleDebitInwardRepostCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/InwardCreditRepostPosting/RepostCreditInwardFilter']")
	WebElement destinationModuleCreditInwardRepostCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/InwardDebitReffralPosting/RefralDebitInwardFilter']")
	WebElement destinationModuleReffralDebitSentCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/InwardCreditReffralPosting/RefralCreditInwardFilter']")
	WebElement destinationModuleReffralCreditSentCheckbox;
	
	@FindBy(xpath = "//tbody/tr[270]/td[7]/input[1]")
	WebElement directDebitModuleListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/fileManager/UploadDDNachFile']")
	WebElement directDebitModuleUploadCheckbox;
	
	@FindBy(xpath = "//tbody/tr[272]/td[7]/input[1]")
	WebElement directDebitModuleCreateReturnACHFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/chargePosting/ChargePostingListFilter']")
	WebElement chargePostingListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/chargePosting/ChargePostingAdd']")
	WebElement chargePostingCreateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/chargePosting/ChargePostingApprove']")
	WebElement chargePostingApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/chargePosting/ChargeInvoice']")
	WebElement chargeInvoiceChargeInvoiceCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/chargePosting/VendorChargeInvoice']")
	WebElement vendorChargeInvoiceCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nameMatchApprove/NameMatchListFilter']")
	WebElement nameMatchLibraryListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nameMatchApprove/NameMatchApprove']")
	WebElement nameMatchLibraryApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nameMatchApprove/NameMatchDelete']")
	WebElement nameMatchLibraryDeleteCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/pay/PayPreList']")
	WebElement paymentListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/pay/PayPreApproveReturn']")
	WebElement paymentApproveReturnCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/pay/PayPreVerifyReceives']")
	WebElement paymentVerifyReceivesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/uploadPaymentsOffline/OfflinePaymentsUploadStart']")
	WebElement paymentOfflineUploadCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/pay/PayPreReferralSent']")
	WebElement paymentReferralReturnCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/InwardAPBCreditManual/InwardAPBCreditManualFilter']")
	WebElement paymentAPBManualCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/InwardAPBCreditManual/InwardAPBCreditManualFilterConfirm']")
	WebElement paymentAPBManualConfirmCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateCustFileLoadOld']")
	WebElement fromUtilityLoadCustomerFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateInitLoad']")
	WebElement fromUtilityInitialLoadCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateImageList']")
	WebElement fromUtilityMandateImageMappingCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateListOutward']")
	WebElement sponsorMandateListMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateOutwardApprove']")
	WebElement sponsorMandateApproveMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateCreate']")
	WebElement sponsorMandateCreateNewMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateAmend']")
	WebElement sponsorMandateAmendMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateCancel']")
	WebElement sponsorMandateCancelMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateModify']")
	WebElement sponsorMandateModifyMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateRegenerate']")
	WebElement sponsorMandateMandatesRegenerationCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateFileApprove']")
	WebElement sponsorMandateMandateFileApproveCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateReject']")
	WebElement sponsorMandateRejectMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/responseMiscListFilter']")
	WebElement sponsorMandateAPIMismatchMandateListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/responseMiscRetryFilter']")
	WebElement sponsorMandateAPIMismatchMandateRetryCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateUnmatchedAPIMandates']")
	WebElement sponsorMandateAcceptRejectUnmatchedAPImandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateListInward']")
	WebElement destinationMandateListMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateAccept']")
	WebElement destinationMandateAcceptMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateInwardApprove']")
	WebElement destinationMandateApproveMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateRelease']")
	WebElement destinationMandateReleaseParkedMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateAuthorise']")
	WebElement destinationMandateAuthoriseMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateAuthoriseAmountExceed']")
	WebElement destinationMandateAuthoriseTreasuryCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateEsignAccept']")
	WebElement destinationMandateAcceptEsignMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateListDD']")
	WebElement directDebitMandateListMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateApproveDD']")
	WebElement directDebitMandateApproveMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateAuthoriseDD']")
	WebElement directDebitMandateAuthoriseMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateAuthoriseAmountExceedDD']")
	WebElement directDebitMandateAuthoriseTreasuryCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateReleaseDD']")
	WebElement directDebitMandateReleaseParkedMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateList']")
	WebElement listMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateApprove']")
	WebElement approveMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateHoldList']")
	WebElement holdMandateHoldListCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateHoldAdd']")
	WebElement holdMandateAddModifyHoldCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateHoldApprove']")
	WebElement holdMandateApproveHoldCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateHoldRemove']")
	WebElement holdMandateRemoveHoldCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate/MandateHoldConfirm']")
	WebElement holdMandateConfirmHoldRemovalCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/mandate/UploadMoratoriumUpdateFile']")
	WebElement uploadMoratoriumFileCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/ServerView/ServerViewAction?method=view']")
	WebElement serverFoldersServerFolderViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/ServerView/ServerViewAction?method=show']")
	WebElement serverFoldersServerFolderCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/MandateGuide']")
	WebElement 	guideMandateFlowNPCICheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/MandateGuide?guideParameter=IN_FLow']")
	WebElement guideMandateInFlowCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/MandateGuide?guideParameter=OUT_FLow']")
	WebElement guideMandateOutFlowCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/fileManager/FolderView']")
	WebElement serverFolderViewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/outwardTransactions']")
	WebElement transactionsOutwardTransactionsCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/achDebitDashboard']")
	WebElement transactionsInwardTransactionsACHDebitCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/achCreditDashboard']")
	WebElement transactionsInwardTransactionsACHCreditCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/apbCreditDashboard']")
	WebElement transactionsInwardTransactionsAPBCreditCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/dashboardTechnologyDateFilter']")
	WebElement transactionsDashboardTechnologyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/dashboardTechnologyDateFilterOnus']")
	WebElement transactionsDDTransactionCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/mandateDashboardFilter']")
	WebElement mandatesMandateDashboardOverviewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/mandateDashboardDailyFilter']")
	WebElement mandatesMandateDashboardDailyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/outwardMandates']")
	WebElement mandatesOutwardMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/mandateDashboardOnusFilter']")
	WebElement mandatesDDMandateDashboardOverviewCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/mandateDashboardDailyFilterOnus']")
	WebElement mandatesDDMandateDashboardDailyCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandateMonitor/inwardMandatesFilter']")
	WebElement mandatesInwardMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/mandateDashboardDailyFilterVendor']")
	WebElement mandateDashboardsVendorMandateDashboardCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/cbdtDashboard']")
	WebElement cbdtCBDTDashboardCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/avDashboard']")
	WebElement avAVDashboardCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/nachMonitor/epfoDashboard']")
	WebElement epfoEPFO_DashboardCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/report/Reconciliation']")
	WebElement reportEODReconciliationCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/report/UserActivity']")
	WebElement reportUserActivityCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/payment_report/InwardPaymentReport']")
	WebElement reportPaymentsInwardCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/payment_report/OutwardPaymentReport']")
	WebElement reportPaymentsOutwardCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/payment_report/DetailPaymentReport']")
	WebElement reportPaymentsTransactionreportCorpCheckbox;
	
	@FindBy(xpath = "//tbody/tr[378]/td[7]/input[1]")
	WebElement reportMandateInwardMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate_report/MandateOutward']")
	WebElement reportMandateOutwardMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate_report/MandateFileReport']")
	WebElement reportMandateMandateFileReportSchemesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/mandate_report/MandateDetailReport']")
	WebElement reportMandateMandatereportCorpCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/Vendor_report/VendorMandateOutward']")
	WebElement reportVendorVendorMandateReportCheckbox;
	
	@FindBy(xpath = "//tbody/tr[384]/td[7]/input[1]")
	WebElement reportVendorVendorTransactionReportCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in_ipayment/ipayment/gps/corporate_report/NachIncomeBooking']")
	WebElement reportChargingReportBookingReportCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in_ipayment/ipayment/gps/corporate_report/BillingInvoiceReport']")
	WebElement reportChargingReportBillingInvoiceCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in_ipayment/ipayment/gps/productivity_report/MandateInwardProductivity']")
	WebElement reportProductivityMandateInwardMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in_ipayment/ipayment/gps/productivity_report/MandateOutwardProductivity']")
	WebElement reportProductivityMandateOutwardMandateCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in_ipayment/ipayment/gps/summary_report/SummaryReport']")
	WebElement reportSummaryCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in_ipayment/ipayment/gps/aadharMapper_report/AadharMapperReport']")
	WebElement reportAadharMapperCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in_ipayment/ipayment/gps/cbdt_report/CbdtReport']")
	WebElement reportCBDTReportCBDTReportCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/report/ReturnReportMemoFilter']")
	WebElement reportReturnMemoCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/SpaceDump']")
	WebElement applicationSupportToolsSpaceDumpCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/pay/SpaceRebuildSelect']")
	WebElement applicationSupportToolsSpaceRebuildCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/wsSimulation/GPSWebService']")
	WebElement applicationSupportToolsWebServiceSimulatorCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/SystemInfo']")
	WebElement applicationSupportToolsSystemInfoCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/TraceFileLevelsList']")
	WebElement applicationSupportToolsTraceFileLevelsCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/DbExplorer']")
	WebElement applicationSupportToolsDBExplorerCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@gps/LockManage']")
	WebElement applicationSupportToolsLockManagementCheckbox;
	
	@FindBy(xpath = "//tbody/tr[405]/td[7]/input[1]")
	WebElement applicationSupportToolsLogExplorerCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/db/ParamConstant?operation=0']")
	WebElement applicationSupportToolsParamConstantsCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/commission/BrUnGrList']")
	WebElement applicationSupportToolsBranchUnitAttributesListBranchDetailsCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/DisplayServerConnections']")
	WebElement applicationSupportToolsBranchUnitAttributesServerConnectionsCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/QueueManageFunction']")
	WebElement applicationSupportToolsBranchUnitAttributesQueueManCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/QueueMessageUploaderFilter']")
	WebElement applicationSupportToolsBranchUnitAttributesQueueMessageUploaderCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@demo/QueueMessageDownloaderFilter']")
	WebElement applicationSupportToolsBranchUnitAttributesQueueMessageDownloaderCheckbox;
	
	@FindBy(xpath = "//tbody/tr[413]/td[7]/input[1]")
	WebElement applicationSupportToolsBranchUnitAttributesLogExplorerCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/mandate_upload/MandateBulkUpload']")
	WebElement applicationSupportToolsUploadMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/gps/mandate_upload_all/MandateBulkUploadAll']")
	WebElement applicationSupportToolsUploadAllMandatesCheckbox;
	
	@FindBy(xpath = "//input[@value='kotak_nach-gps-menu@in/kotak_nach/gps/directDebitMandate/MandateDDBulkUpload']")
	WebElement applicationSupportToolsMandateDirectDebitUploadCheckbox;

	// Approve profile menus xpath

	@FindBy(xpath = "//input[@name='reject']")
	WebElement rejectRecord;

	@FindBy(xpath = "//input[@name='repair']")
	WebElement repairRecord;

	@FindBy(xpath = "//input[@name='approve']")
	WebElement btnApprove;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement listScreenProfileNameValue;

	@FindBy(xpath="//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[3]")
	WebElement listScreenProfileStatus;

	// Remove button
	@FindBy(id = "btnRemove")
	WebElement btnRemove;

	@FindBy(xpath = "//*[@id=\"LNTablelistable\"]/tbody/tr[2]/td[2]")
	WebElement removeScreenProfileNameValue;

	// Remove Message
	@FindBy(xpath = "//*[@id=\"pageBody\"]/p")
	WebElement removeMsg;

	@FindBy(name = "profileName")
	WebElement textfieldRemoveProfile;

	@FindBy(name = "profileName")
	WebElement textFieldProfileName;

	@FindBy(xpath="//*[@id=\"pageBody\"]/table/tbody/tr[1]/td/table[2]/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]")
	WebElement ScreenProfileNameTxtValue;

	@FindBy(xpath = "//p[@class='messages']")
	WebElement messages;

	// WebElements for Logout function
	@FindBy(id = "logoutButtonId")
	WebElement logOutBtn;

	@FindBy(xpath = "//*[@id=\"pageBody\"]/table/tbody/tr/td/form/button")
	WebElement logoutBtn;

	// ProfilePage Class Constructor
	public ProfilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.homePage = new HomePage(driver);
		this.elementUtil = new ElementUtil(driver);
		this.fileReader = new FileReadUtils(driver);

	}//end

	//--------------Method to Add Profile Record------------------------//
	public void addprofile(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		test_Data = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String ProfileName = map.get("Profile Name");
//			String Checkboxes = map.get("Checkboxes");
			String Password = map.get("Password");
			String Logout = map.get("Logout");
			String Log_View = map.get("Log-View");
			String SecurityParameters_View = map.get("Security Parameters-View");
			String Security_Parameters_Modify = map.get("Security Parameters-Modify");
			String Security_Parameters_Approve = map.get("Security Parameters-Approve");
			String User_View = map.get("User-View");
			String User_Add = map.get("User-Add");
			String User_Modify = map.get("User-Modify/Repair");
			String User_Approve = map.get("User-Approve");
			String User_BlockUnblock = map.get("User-Block/Unblock");
			String User_Remove = map.get("User-Remove");
			String User_ReportView = map.get("User-Report View");
			String Group_List = map.get("Group-List");
			String Group_Add = map.get("Group-Add");
			String Group_Modify = map.get("Group-Modify");
			String Group_Approve = map.get("Group-Approve");
			String Group_Block = map.get("Group-Block");
			String Group_Unblock = map.get("Group-Unblock");
			String Group_Remove = map.get("Group-Remove");
			String Group_ReportBuild = map.get("Group-ReportBuild");
			String Group_ReportView = map.get("Group-ReportView");
			String Profiles_List = map.get("Profiles-List");
			String Profiles_Add = map.get("Profiles-Add");
			String Profiles_Modify = map.get("Profiles-Modify/Repair");
			String Profiles_Approve = map.get("Profiles-Approve");
			String Profiles_Remove = map.get("Profiles-Remove");
			String Profiles_ReportBuild = map.get("Profiles-ReportBuild");
			String Profiles_ReportView = map.get("Profiles-ReportView");
			String LoginMatrix_List = map.get("Login Matrix-List");
			String LoginMatrix_Add = map.get("Login Matrix-Add");
			String LoginMatrix_Modify = map.get("Login Matrix-Modify");
			String LoginMatrix_Delete = map.get("Login Matrix-Delete");
			String Environment_GlobalProcesses = map.get("Environment-Global/Processes");
			String Environment_Run = map.get("Environment-Run");
			String Environment_Show = map.get("Environment-Show");
			String Calendar_View = map.get("Calendar-View");
			String Calendar_Create = map.get("Calendar-Create");
			String Calendar_Modify = map.get("Calendar-Modify/Repair");
			String Calendar_Approve = map.get("Calendar-Approve");
			String Certificate_List = map.get("Certificate-List");
			String Certificate_Add = map.get("Certificate-Add");
			String Certificate_Modify = map.get("Certificate-Modify");
			String Certificate_Delete = map.get("Certificate-Delete");
			String NPCICertificate_List = map.get("NPCI Certificate-List");
			String NPCICertificate_Add = map.get("NPCI Certificate-Add");
			String NPCICertificate_Modify = map.get("NPCI Certificate-Modify");
			String NPCICertificate_Delete = map.get("NPCI Certificate-Delete");
			String Customer_List = map.get("Customer-List");
			String Customer_Add = map.get("Customer-Add");
			String Customer_Approve = map.get("Customer-Approve");
			String Customer_Modify = map.get("Customer-Modify");
			String Customer_Delete = map.get("Customer-Delete");
			String Customer_ConfirmDelete = map.get("Customer-Confirm Delete");
			String Customer_SchemeFormatCodeMapping = map.get("Customer-Scheme/Format Code Mapping");
			String Scheme_List = map.get("Scheme-List");
			String Scheme_Add = map.get("Scheme-Add");
			String Scheme_Approve = map.get("Scheme-Approve");
			String Scheme_Modify = map.get("Scheme-Modify");
			String Scheme_Delete = map.get("Scheme-Delete");
			String Scheme_ConfirmDelete = map.get("Scheme-Confirm Delete");
			String Scheme_Upload = map.get("Scheme-Upload");
			String Scheme_Download = map.get("Scheme-Download");
			String RelationshipManager_List = map.get("Relationship Manager-List");
			String RelationshipManager_Add = map.get("Relationship Manager-Add");
			String RelationshipManager_Approve = map.get("Relationship Manager-Approve");
			String RelationshipManager_Modify = map.get("Relationship Manager-Modify");
			String RelationshipManager_Delete = map.get("Relationship Manager-Delete");
			String RelationshipManager_ConfirmDelete = map.get("Relationship Manager-Confirm Delete");
			String Miscellaneous_List = map.get("Miscellaneous-List");
			String Miscellaneous_Add = map.get("Miscellaneous-Add");
			String Miscellaneous_Approve = map.get("Miscellaneous-Approve");
			String Miscellaneous_Modify = map.get("Miscellaneous-Modify");
			String Miscellaneous_Delete = map.get("Miscellaneous-Delete");
			String Miscellaneous_ConfirmDelete = map.get("Miscellaneous-Confirm Delete");
			String Accounting_List = map.get("Accounting-List");
			String Accounting_Add = map.get("Accounting-Add");
			String Accounting_Approve = map.get("Accounting-Approve");
			String Accounting_Modify = map.get("Accounting-Modify");
			String Accounting_Delete = map.get("Accounting-Delete");
			String Accounting_ConfirmDelete = map.get("Accounting-Confirm Delete");
			String Authorization_List = map.get("Authorization-List");
			String Authorization_Add = map.get("Authorization-Add");
			String Authorization_Approve = map.get("Authorization-Approve");
			String Authorization_Modify = map.get("Authorization-Modify");
			String Authorization_Delete = map.get("Authorization-Delete");
			String Authorization_ConfirmDelete = map.get("Authorization-Confirm Delete");
			String AlertandNotification_List = map.get("Alert and Notification-List");
			String AlertandNotification_Add = map.get("Alert and Notification-Add");
			String AlertandNotification_Approve = map.get("Alert and Notification-Approve");
			String AlertandNotification_Modify = map.get("Alert and Notification-Modify");
			String AlertandNotification_Delete = map.get("Alert and Notification-Delete");
			String AlertandNotification_ConfirmDelete = map.get("Alert and Notification-Confirm Delete");
			String ModeOfOperation_List = map.get("Mode Of Operation-List");
			String ModeOfOperation_Add = map.get("Mode Of Operation-Add");
			String ModeOfOperation_Approve = map.get("Mode Of Operation-Approve");
			String ModeOfOperation_Modify = map.get("Mode Of Operation-Modify");
			String ModeOfOperation_Delete = map.get("Mode Of Operation-Delete");
			String ModeOfOperation_ConfirmDelete = map.get("Mode Of Operation-Confirm Delete");
			String IndustryType_List = map.get("Industry Type-List");
			String IndustryType_Add = map.get("Industry Type-Add");
			String IndustryType_Approve = map.get("Industry Type-Approve");
			String IndustryType_Modify = map.get("Industry Type-Modify");
			String IndustryType_Delete = map.get("Industry Type-Delete");
			String IndustryType_ConfirmDelete = map.get("Industry Type-Confirm Delete");
			String BusinessGroup_List = map.get("Business Group-List");
			String BusinessGroup_Add = map.get("Business Group-Add");
			String BusinessGroup_Approve = map.get("Business Group-Approve");
			String BusinessGroup_Modify = map.get("Business Group-Modify");
			String BusinessGroup_Delete = map.get("Business Group-Delete");
			String BusinessGroup_ConfirmDelete = map.get("Business Group-Confirm Delete");
			String DuplicateCheck_List = map.get("Duplicate Check-List");
			String DuplicateCheck_Add = map.get("Duplicate Check-Add");
			String DuplicateCheck_Approve = map.get("Duplicate Check-Approve");
			String DuplicateCheck_Modify = map.get("Duplicate Check-Modify");
			String DuplicateCheck_Delete = map.get("Duplicate Check-Delete");
			String DuplicateCheck_ConfirmDelete = map.get("Duplicate Check-Confirm Delete");
			String RepresentMapping_List = map.get("Represent Mapping-List");
			String RepresentMapping_Add = map.get("Represent Mapping-Add");
			String RepresentMapping_Approve = map.get("Represent Mapping-Approve");
			String RepresentMapping_Modify = map.get("Represent Mapping-Modify");
			String RepresentMapping_Delete = map.get("Represent Mapping-Delete");
			String RepresentMapping_ConfirmDelete = map.get("Represent Mapping-Confirm Delete");
			String Vendor_List = map.get("Vendor-List");
			String Vendor_Add = map.get("Vendor-Add");
			String Vendor_Approve = map.get("Vendor-Approve");
			String Vendor_Modify = map.get("Vendor-Modify");
			String Vendor_Delete = map.get("Vendor-Delete");
			String Vendor_ConfirmDelete = map.get("Vendor-Confirm Delete");
			String Vendor_SchemeFormatCodeMapping = map.get("Vendor-Scheme/Format Code Mapping");
			String Charge_List = map.get("Charge-List");
			String Charge_Add = map.get("Charge-Add");
			String Charge_Approve = map.get("Charge-Approve");
			String Charge_Modify = map.get("Charge-Modify");
			String Charge_Delete = map.get("Charge-Delete");
			String Charge_ConfirmDelete = map.get("Charge-Confirm Delete");
			String CorporateChargePosting_List = map.get("Corporate Charge Posting-List");
			String CorporateChargePosting_Add = map.get("Corporate Charge Posting-Add");
			String CorporateChargePosting_Modify = map.get("Corporate Charge Posting-Modify");
			String CorporateChargePosting_GenerateReport = map.get("Corporate Charge Posting-Generate Report");
			String CorporateChargePosting_ChargePosting = map.get("Corporate Charge Posting-Charge Posting");
			String IFSCCODE_List = map.get("IFSCCODE-List");
			String IFSCCODE_Add = map.get("IFSCCODE-Add");
			String IFSCCODE_Approve = map.get("IFSCCODE-Approve");
			String IFSCCODE_Modify = map.get("IFSCCODE-Modify");
			String IFSCCODE_Delete = map.get("IFSCCODE-Delete");
			String IFSCCODE_ConfirmDelete = map.get("IFSCCODE-Confirm Delete");
			String NPCICodes_MaintainNPCICodes = map.get("NPCI Codes-Maintain NPCI Codes");
			String NPCICodes_ListNPCICodes = map.get("NPCI Codes-List NPCI Codes");
			String DBLoads = map.get("DB Loads");
			String SubMemberIFSCCODE_Upload = map.get("Sub-Member IFSCCODE-Upload");
			String SubMemberIFSCCODE_List = map.get("Sub-Member IFSCCODE-List");
			String SubMemberIFSCCODE_Add = map.get("Sub-Member IFSCCODE-Add");
			String SubMemberIFSCCODE_Approve = map.get("Sub-Member IFSCCODE-Approve");
			String SubMemberIFSCCODE_Modify = map.get("Sub-Member IFSCCODE-Modify");
			String SubMemberIFSCCODE_Delete = map.get("Sub-Member IFSCCODE-Delete");
			String SubMemberIFSCCODE_ConfirmDelete = map.get("Sub-Member IFSCCODE-Confirm Delete");
			String ParameterMaintenance = map.get("Parameter Maintenance");
			String DistributionSets_List = map.get("Distribution Sets-List");
			String DistributionSets_Add = map.get("Distribution Sets-Add");
			String DistributionSets_Approve = map.get("Distribution Sets-Approve");
			String DistributionSets_Modify = map.get("Distribution Sets-Modify");
			String DistributionSets_Delete = map.get("Distribution Sets-Delete");
			String Messages_View = map.get("Messages-View");
			String Messages_New = map.get("Messages-New");
			String Schedule_List = map.get("Schedule-List");
			String Schedule_New = map.get("Schedule-New");
			String Schedule_Modify = map.get("Schedule-Modify");
			String Schedule_Control = map.get("Schedule-Control");
			String FTPSFTPParameters_List = map.get("FTP-SFTP Parameters-List");
			String FTPSFTPParameters_Add = map.get("FTP-SFTP Parameters-Add");
			String FTPSFTPParameters_Modify = map.get("FTP-SFTP Parameters-Modify");
			String FTPSFTPParameters_FTPSFTPFileList = map.get("FTP-SFTP Parameters-FTP-SFTP File List");
			String FAQMaintainFAQ = map.get("FAQ-Maintain FAQ");
			String FAQListFAQ = map.get("FAQ-List FAQ");
			String SessionMaintenance_List = map.get("Session Maintenance-List");
			String SessionMaintenance_Add = map.get("Session Maintenance-Add");
			String SessionMaintenance_Modify = map.get("Session Maintenance-Modify");
			String SessionMaintenance_Delete = map.get("Session Maintenance-Delete");
			String NameMatching_List = map.get("Name Matching-List");
			String NameMatching_Add = map.get("Name Matching-Add");
			String NameMatching_Modify = map.get("Name Matching-Modify");
			String NameMatching_Delete = map.get("Name Matching-Delete");
			String Corporate_List = map.get("Corporate-List");
			String Corporate_Add = map.get("Corporate-Add");
			String Corporate_Modify = map.get("Corporate-Modify");
			String Corporate_Delete = map.get("Corporate-Delete");
			String FreeFormatCode_List = map.get("Free Format Code-List");
			String FreeFormatCode_Add = map.get("Free Format Code-Add");
			String FreeFormatCode_Copy = map.get("Free Format Code-Copy");
			String FreeFormatCode_Approve = map.get("Free Format Code-Approve");
			String FreeFormatCode_Modify = map.get("Free Format Code-Modify");
			String FreeFormatCode_Delete = map.get("Free Format Code-Delete");
			String FreeFormatCode_ConfirmDelete = map.get("Free Format Code-Confirm Delete");
			String FileManager_List = map.get("File Manager-List");
			String FileManager_ApprovePostingFile = map.get("File Manager-Approve Posting File");
			String SponsorModule_CreateACHFile = map.get("Sponsor Module- Create ACH File");
			String SponsorModule_Accept = map.get("Sponsor Module- Accept");
			String SponsorModule_Upload = map.get("Sponsor Module-Upload");
			String SponsorModule_UploadAPBSFile = map.get("Sponsor Module- Upload APBS File");
			String SponsorModule_RejectFutureFile = map.get("Sponsor Module- Reject Future File");
			String SponsorModule_Repost = map.get("Sponsor Module- Repost");
			String SponsorModule_ApprovePossibleReject = map.get("Sponsor Module- Approve Possible Reject");
			String SponsorModule_ExportMis = map.get("Sponsor Module- Export Mis");
			String DestinationModule_CreateReturnACHFile = map.get("Destination Module-Create Return ACH File");
			String DestinationModule_UploadOldNewAccountMapper = map.get("Destination Module-Upload Old-New Account Mapper");
			String DestinationModule_DebitInwardRepost = map.get("Destination Module-Debit Inward Repost");
			String DestinationModule_CreditInwardRepost = map.get("Destination Module-Credit Inward Repost");
			String DestinationModule_ReffralDebitSent = map.get("Destination Module-Reffral Debit Sent");
			String DestinationModule_ReffralCreditSent = map.get("Destination Module-Reffral Credit Sent");
			String DirectDebitModule_List = map.get("Direct Debit Module-List");
			String DirectDebitModule_Upload = map.get("Direct Debit Module-Upload");
			String DirectDebitModule_CreateReturnACHFile = map.get("Direct Debit Module-Create Return ACH File");
			String ChargePosting_List = map.get("Charge Posting-List");
			String ChargePosting_Create = map.get("Charge Posting-Create");
			String ChargePosting_Approve = map.get("Charge Posting-Approve");
			String ChargeInvoice_ChargeInvoice = map.get("Charge Invoice-Charge Invoice");
			String VendorChargeInvoice = map.get("Vendor Charge Invoice");
			String NameMatchLibrary_List = map.get("Name Match Library-List");
			String NameMatchLibrary_Approve = map.get("Name Match Library-Approve");
			String NameMatchLibrary_Delete = map.get("Name Match Library-Delete");
			String Payment_List = map.get("Payment-List");
			String Payment_ApproveReturn = map.get("Payment-Approve Return");
			String Payment_VerifyReceives = map.get("Payment-Verify Receives");
			String Payment_OfflineUpload = map.get("Payment-Offline Upload");
			String Payment_ReferralReturn = map.get("Payment-Referral Return");
			String Payment_APBManual = map.get("Payment-APB Manual");
			String Payment_APBManualConfirm = map.get("Payment-APB Manual Confirm");
			String FromUtility_LoadCustomerFile = map.get("From Utility-Load Customer File");
			String FromUtility_InitialLoad = map.get("From Utility-Initial Load");
			String FromUtility_MandateImageMapping = map.get("From Utility-Mandate Image Mapping");
			String SponsorMandate_ListMandates = map.get("Sponsor Mandate-List Mandates");
			String SponsorMandate_ApproveMandate = map.get("Sponsor Mandate-Approve Mandate");
			String SponsorMandate_CreateNewMandate = map.get("Sponsor Mandate-Create New Mandate");
			String SponsorMandate_AmendMandate = map.get("Sponsor Mandate-Amend Mandate");
			String SponsorMandate_CancelMandate = map.get("Sponsor Mandate-Cancel Mandate");
			String SponsorMandate_ModifyMandate = map.get("Sponsor Mandate-Modify Mandate");
			String SponsorMandate_MandatesRegeneration = map.get("Sponsor Mandate-Mandates Regeneration");
			String SponsorMandate_MandateFileApprove = map.get("Sponsor Mandate-Mandate File Approve");
			String SponsorMandate_RejectMandate = map.get("Sponsor Mandate-Reject Mandate");
			String SponsorMandate_APIMismatchMandate_List = map.get("Sponsor Mandate-API Mismatch Mandate-List");
			String SponsorMandate_APIMismatchMandate_Retry = map.get("Sponsor Mandate-API Mismatch Mandate-Retry");
			String SponsorMandate_AcceptRejectUnmatchedAPImandates = map.get("Sponsor Mandate-Accept/Reject Unmatched API mandates");
			String DestinationMandate_ListMandates = map.get("Destination Mandate-List Mandates");
			String DestinationMandate_ApproveMandate = map.get("Destination Mandate-Approve Mandate");
			String DestinationMandate_AuthoriseMandate = map.get("Destination Mandate-Authorise Mandate");
			String DestinationMandate_AuthoriseTreasury = map.get("Destination Mandate-Authorise Treasury");
			String DestinationMandate_ReleaseParkedMandate = map.get("Destination Mandate-Release Parked Mandates");
			String ListMandates = map.get("List Mandates");
			String ApproveMandate = map.get("Approve Mandate");
			String HoldMandate_HoldList = map.get("Hold Mandate-Hold List");
			String HoldMandate_AddModifyHold = map.get("Hold Mandate-Add/Modify Hold");
			String HoldMandate_ApproveHold = map.get("Hold Mandate-Approve Hold");
			String HoldMandate_RemoveHold = map.get("Hold Mandate-Remove Hold");
			String HoldMandate_ConfirmHoldRemoval = map.get("Hold Mandate-Confirm Hold Removal");
			String UploadMoratoriumFile = map.get("Upload Moratorium File");
			String ServerFolders_ServerFolderView = map.get("Server Folders-Server Folder View");
			String ServerFolders_ServerFolder = map.get("Server Folders-Server Folder");
			String GuideMandateFlowNPCI = map.get("Guide-Mandate Flow [NPCI]");
			String GuideMandateInFlow = map.get("Guide-Mandate In Flow");
			String GuideMandateOutFlow = map.get("Guide-Mandate Out Flow");
			String ServerFolderView = map.get("Server Folder View");
			String Transactions_OutwardTransactions = map.get("Transactions-Outward Transactions");
			String Transactions_InwardTransactions_ACHDebit = map.get("Transactions-Inward Transactions-ACH Debit");
			String Transactions_InwardTransactions_ACHCredit = map.get("Transactions-Inward Transactions-ACH Credit");
			String Transactions_InwardTransactions_APBCredit = map.get("Transactions-Inward Transactions-APB Credit");
			String Transactions_DashboardTechnology = map.get("Transactions-Dashboard Technology");
			String Transactions_DDTransaction = map.get("Transactions-DD Transaction");
			String Mandates_MandateDashboardOverview = map.get("Mandates-Mandate Dashboard(Overview)");
			String Mandates_MandateDashboardDaily = map.get("Mandates-Mandate Dashboard(Daily)");
			String Mandates_OutwardMandates = map.get("Mandates-Outward Mandates");
			String Mandates_DDMandateDashboardOverview = map.get("Mandates-DD Mandate Dashboard(Overview)");
			String Mandates_DDMandateDashboardDaily = map.get("Mandates-DD Mandate Dashboard(Daily)");
			String Mandates_InwardMandates = map.get("Mandates-Inward Mandates");
			String MandateDashboards_VendorMandateDashboard = map.get("Mandate Dashboards- Vendor Mandate Dashboard");
			String CBDT_CBDTDashboard = map.get("CBDT-CBDT Dashboard");
			String AV_AVDashboard = map.get("AV- AV Dashboard");
			String EPFO_EPFO_Dashboard = map.get("EPFO-EPFO_Dashboard");
			String Report_EODReconciliation = map.get("Report-EOD Reconciliation");
			String Report_UserActivity = map.get("Report-User Activity");
			String Report_Payments_Inward = map.get("Report-Payments-Inward");
			String Report_Payments_Outward = map.get("Report-Payments-Outward");
			String Report_Payments_TransactionreportCorp = map.get("Report-Payments-Transaction report (Corp)");
			String Report_Mandate_InwardMandate = map.get("Report-Mandate-Inward Mandate");
			String Report_Mandate_OutwardMandate = map.get("Report-Mandate-Outward Mandate");
			String Report_Mandate_MandateFileReportSchemes = map.get("Report-Mandate-Mandate File Report(Schemes)");
			String Report_Mandate_MandatereportCorp = map.get("Report-Mandate-Mandate report(Corp)");
			String Report_Vendor_VendorMandateReport = map.get("Report-Vendor-Vendor Mandate Report");
			String Report_Vendor_VendorTransactionReport = map.get("Report-Vendor-Vendor Transaction Report");
			String Report_ChargingReport_BookingReport = map.get("Report-Charging Report-Booking Report");
			String Report_ChargingReport_BillingInvoice = map.get("Report-Charging Report-Billing Invoice");
			String Report_Productivity_Mandate_InwardMandate = map.get("Report-Productivity-Mandate-Inward Mandate");
			String Report_Productivity_Mandate_OutwardMandate = map.get("Report-Productivity-Mandate-Outward Mandate");
			String Report_Summary = map.get("Report-Summary");
			String Report_AadharMapper = map.get("Report-Aadhar Mapper");
			String ReportCBDT_ReportCBDTReport = map.get("Report-CBDT Report-CBDT Report");
			String Report_ReturnMemo = map.get("Report-Return Memo");
			String ApplicationSupportTools_SpaceDump= map.get("Application Support Tools-Space Dump");
			String ApplicationSupportTools_SpaceRebuild = map.get("Application Support Tools-Space Rebuild");
			String ApplicationSupportTools_WebServiceSimulator = map.get("Application Support Tools-Web Service Simulator");
			String ApplicationSupportTools_SystemInfo = map.get("Application Support Tools-System Info");
			String ApplicationSupportTools_TraceFileLevels = map.get("Application Support Tools-TraceFile Levels");
			String ApplicationSupportTools_DBExplorer = map.get("Application Support Tools-DB Explorer");
			String ApplicationSupportTools_LockManagement = map.get("Application Support Tools-Lock Management");
			String ApplicationSupportTools_LogExplorer = map.get("Application Support Tools-Log Explorer");
			String ApplicationSupportTools_ParamConstants = map.get("Application Support Tools-Param Constants");
			String ApplicationSupportTools_BranchUnitAttributes_ListBranchDetails = map.get("Application Support Tools-Branch/Unit Attributes-List Branch Details");
			String ApplicationSupportTools_BranchUnitAttributes_ServerConnections = map.get("Application Support Tools-Branch/Unit Attributes-Server Connections");
			String ApplicationSupportTools_BranchUnitAttributes_QueueMan = map.get("Application Support Tools-Branch/Unit Attributes-Queue Man.");
			String ApplicationSupportTools_BranchUnitAttributes_QueueMessageUploader = map.get("Application Support Tools-Branch/Unit Attributes-Queue Message Uploader");
			String ApplicationSupportTools_BranchUnitAttributes_QueueMessageDownloader = map.get("Application Support Tools-Branch/Unit Attributes-Queue Message Downloader");
			String ApplicationSupportTools_BranchUnitAttributes_LogExplorer = map.get("Application Support Tools-Branch/Unit Attributes-Log Explorer");
			String ApplicationSupportTools_UploadMandates = map.get("Application Support Tools-Upload Mandates");
			String ApplicationSupportTools_UploadAllMandates = map.get("Application Support Tools-Upload All Mandates");
			String ApplicationSupportTools_MandateDirectDebitUpload = map.get("Application Support Tools-Mandate Direct Debit Upload");
			
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(btnCancel);

			String ExpectedCancelBtnValidationMsg = "Operation Add new profile was cancelled.";

			if (elementUtil.getText(errormessages).equals(ExpectedCancelBtnValidationMsg)) {
				log.info("Cancel button is working fine for Profile-->Add Screen");
			} else {
				log.error("Cancel button is not working for Profile-->Add Screen");
			}

			elementUtil.clickElement(restartWorkFlowBtn);
			elementUtil.enterText(profileNameTxtField, ProfileName);
			elementUtil.clickElement(resetBtn);
			
			if(elementUtil.getAttribute(profileNameTxtField).isEmpty()) {
				log.info("Reset button is working fine for Profile-->Add Screen");
			}else {
				log.error("Reset button is not working for Profile-->Add Screen");
			}
			
			elementUtil.sendkeys(profileNameTxtField, ProfileName);
//			elementUtil.isElementSelected(, Checkboxes);
			elementUtil.isElementSelected(passwordCheckbox, Password);
			elementUtil.isElementSelected(logoutCheckbox, Logout);
			elementUtil.isElementSelected(logViewCheckbox, Log_View);
			elementUtil.isElementSelected(securityParametersViewCheckbox, SecurityParameters_View);
			elementUtil.isElementSelected(securityParametersModifyCheckbox, Security_Parameters_Modify);
			elementUtil.isElementSelected(securityParametersApproveCheckbox, Security_Parameters_Approve);
			elementUtil.isElementSelected(userViewCheckbox, User_View);
			elementUtil.isElementSelected(userAddCheckbox, User_Add);
			elementUtil.isElementSelected(userModifyCheckbox, User_Modify);
			elementUtil.isElementSelected(userApproveCheckbox, User_Approve);
			elementUtil.isElementSelected(userBlockUnblockCheckbox, User_BlockUnblock);
			elementUtil.isElementSelected(userRemoveCheckbox, User_Remove);
			elementUtil.isElementSelected(userReportViewCheckbox, User_ReportView);
			elementUtil.isElementSelected(groupListCheckbox, Group_List);
			elementUtil.isElementSelected(groupAddCheckbox, Group_Add);
			elementUtil.isElementSelected(groupModifyCheckbox, Group_Modify);
			elementUtil.isElementSelected(groupApproveCheckbox, Group_Approve);
			elementUtil.isElementSelected(groupBlockCheckbox, Group_Block);
			elementUtil.isElementSelected(groupUnblockCheckbox, Group_Unblock);
			elementUtil.isElementSelected(groupRemoveCheckbox, Group_Remove);
			elementUtil.isElementSelected(groupReportBuildCheckbox, Group_ReportBuild);
			elementUtil.isElementSelected(groupReportViewCheckbox, Group_ReportView);
			elementUtil.isElementSelected(profilesListCheckbox, Profiles_List);
			elementUtil.isElementSelected(profilesAddCheckbox, Profiles_Add);
			elementUtil.isElementSelected(profilesModifyCheckbox, Profiles_Modify);
			elementUtil.isElementSelected(profilesApproveCheckbox, Profiles_Approve);
			elementUtil.isElementSelected(profilesRemoveCheckbox, Profiles_Remove);
			elementUtil.isElementSelected(profilesReportBuildCheckbox, Profiles_ReportBuild);
			elementUtil.isElementSelected(profilesReportViewCheckbox, Profiles_ReportView);
			elementUtil.isElementSelected(loginMatrixListCheckbox, LoginMatrix_List);
			elementUtil.isElementSelected(loginMatrixAddCheckbox, LoginMatrix_Add);
			elementUtil.isElementSelected(loginMatrixModifyCheckbox, LoginMatrix_Modify);
			elementUtil.isElementSelected(loginMatrixDeleteCheckbox, LoginMatrix_Delete);
			elementUtil.isElementSelected(environmentGlobalProcessesCheckbox, Environment_GlobalProcesses);
			elementUtil.isElementSelected(environmentRunCheckbox, Environment_Run);
			elementUtil.isElementSelected(environmentShowCheckbox, Environment_Show);
			elementUtil.isElementSelected(calendarViewCheckbox, Calendar_View);
			elementUtil.isElementSelected(calendarCreateCheckbox, Calendar_Create);
			elementUtil.isElementSelected(calendarModifyCheckbox, Calendar_Modify);
			elementUtil.isElementSelected(calendarApproveCheckbox, Calendar_Approve);
			elementUtil.isElementSelected(certificateListCheckbox, Certificate_List);
			elementUtil.isElementSelected(certificateAddCheckbox, Certificate_Add);
			elementUtil.isElementSelected(certificateModifyCheckbox, Certificate_Modify);
			elementUtil.isElementSelected(certificateDeleteCheckbox, Certificate_Delete);
			elementUtil.isElementSelected(npciCertificateListCheckbox, NPCICertificate_List);
			elementUtil.isElementSelected(npciCertificateAddCheckbox, NPCICertificate_Add);
			elementUtil.isElementSelected(npciCertificateModifyCheckbox, NPCICertificate_Modify);
			elementUtil.isElementSelected(npciCertificateDeleteCheckbox, NPCICertificate_Delete);
			elementUtil.isElementSelected(customerListCheckbox, Customer_List);
			elementUtil.isElementSelected(customerAddCheckbox, Customer_Add);
			elementUtil.isElementSelected(customerApproveCheckbox, Customer_Approve);
			elementUtil.isElementSelected(customerModifyCheckbox, Customer_Modify);
			elementUtil.isElementSelected(customerDeleteCheckbox, Customer_Delete);
			elementUtil.isElementSelected(customerConfirmDeleteCheckbox, Customer_ConfirmDelete);
			elementUtil.isElementSelected(customerSchemeFormatCodeMappingCheckbox, Customer_SchemeFormatCodeMapping);
			elementUtil.isElementSelected(schemeListCheckbox, Scheme_List);
			elementUtil.isElementSelected(schemeAddCheckbox, Scheme_Add);
			elementUtil.isElementSelected(schemeApproveCheckbox, Scheme_Approve);
			elementUtil.isElementSelected(schemeModifyCheckbox, Scheme_Modify);
			elementUtil.isElementSelected(schemeDeleteCheckbox, Scheme_Delete);
			elementUtil.isElementSelected(schemeConfirmDeleteCheckbox, Scheme_ConfirmDelete);
			elementUtil.isElementSelected(schemeUploadCheckbox, Scheme_Upload);
			elementUtil.isElementSelected(schemeDownloadCheckbox, Scheme_Download);
			elementUtil.isElementSelected(relationshipManagerListCheckbox, RelationshipManager_List);
			elementUtil.isElementSelected(relationshipManagerAddCheckbox, RelationshipManager_Add);
			elementUtil.isElementSelected(relationshipManagerApproveCheckbox, RelationshipManager_Approve);
			elementUtil.isElementSelected(relationshipManagerModifyCheckbox, RelationshipManager_Modify);
			elementUtil.isElementSelected(relationshipManagerDeleteCheckbox, RelationshipManager_Delete);
			elementUtil.isElementSelected(relationshipManagerConfirmDeleteCheckbox, RelationshipManager_ConfirmDelete);
			elementUtil.isElementSelected(miscellaneousListCheckbox, Miscellaneous_List);
			elementUtil.isElementSelected(miscellaneousAddCheckbox, Miscellaneous_Add);
			elementUtil.isElementSelected(miscellaneousApproveCheckbox, Miscellaneous_Approve);
			elementUtil.isElementSelected(miscellaneousModifyCheckbox, Miscellaneous_Modify);
			elementUtil.isElementSelected(miscellaneousDeleteCheckbox, Miscellaneous_Delete);
			elementUtil.isElementSelected(miscellaneousConfirmDeleteCheckbox, Miscellaneous_ConfirmDelete);
			elementUtil.isElementSelected(accountingListCheckbox, Accounting_List);
			elementUtil.isElementSelected(accountingAddCheckbox, Accounting_Add);
			elementUtil.isElementSelected(accountingApproveCheckbox, Accounting_Approve);
			elementUtil.isElementSelected(accountingModifyCheckbox, Accounting_Modify);
			elementUtil.isElementSelected(accountingDeleteCheckbox, Accounting_Delete);
			elementUtil.isElementSelected(accountingConfirmDeleteCheckbox, Accounting_ConfirmDelete);
			elementUtil.isElementSelected(authorizationListCheckbox, Authorization_List);
			elementUtil.isElementSelected(authorizationAddCheckbox, Authorization_Add);
			elementUtil.isElementSelected(authorizationApproveCheckbox, Authorization_Approve);
			elementUtil.isElementSelected(authorizationModifyCheckbox, Authorization_Modify);
			elementUtil.isElementSelected(authorizationDeleteCheckbox, Authorization_Delete);
			elementUtil.isElementSelected(authorizationConfirmDeleteCheckbox, Authorization_ConfirmDelete);
			elementUtil.isElementSelected(alertandNotificationListCheckbox, AlertandNotification_List);
			elementUtil.isElementSelected(alertandNotificationAddCheckbox, AlertandNotification_Add);
			elementUtil.isElementSelected(alertandNotificationApproveCheckbox, AlertandNotification_Approve);
			elementUtil.isElementSelected(alertandNotificationModifyCheckbox, AlertandNotification_Modify);
			elementUtil.isElementSelected(alertandNotificationDeleteCheckbox, AlertandNotification_Delete);
			elementUtil.isElementSelected(alertandNotificationConfirmDeleteCheckbox, AlertandNotification_ConfirmDelete);
			elementUtil.isElementSelected(modeOfOperationListCheckbox, ModeOfOperation_List);
			elementUtil.isElementSelected(modeOfOperationAddCheckbox, ModeOfOperation_Add);
			elementUtil.isElementSelected(modeOfOperationApproveCheckbox, ModeOfOperation_Approve);
			elementUtil.isElementSelected(modeOfOperationModifyCheckbox, ModeOfOperation_Modify);
			elementUtil.isElementSelected(modeOfOperationDeleteCheckbox, ModeOfOperation_Delete);
			elementUtil.isElementSelected(modeOfOperationConfirmDeleteCheckbox, ModeOfOperation_ConfirmDelete);
			elementUtil.isElementSelected(industryTypeListCheckbox, IndustryType_List);
			elementUtil.isElementSelected(industryTypeAddCheckbox, IndustryType_Add);
			elementUtil.isElementSelected(industryTypeApproveCheckbox, IndustryType_Approve);
			elementUtil.isElementSelected(industryTypeModifyCheckbox, IndustryType_Modify);
			elementUtil.isElementSelected(industryTypeDeleteCheckbox, IndustryType_Delete);
			elementUtil.isElementSelected(industryTypeConfirmDeleteCheckbox, IndustryType_ConfirmDelete);
			elementUtil.isElementSelected(businessGroupListCheckbox, BusinessGroup_List);
			elementUtil.isElementSelected(businessGroupAddCheckbox, BusinessGroup_Add);
			elementUtil.isElementSelected(businessGroupApproveCheckbox, BusinessGroup_Approve);
			elementUtil.isElementSelected(businessGroupModifyCheckbox, BusinessGroup_Modify);
			elementUtil.isElementSelected(businessGroupDeleteCheckbox, BusinessGroup_Delete);
			elementUtil.isElementSelected(businessGroupConfirmDeleteCheckbox, BusinessGroup_ConfirmDelete);
			elementUtil.isElementSelected(duplicateCheckListCheckbox, DuplicateCheck_List);
			elementUtil.isElementSelected(duplicateCheckAddCheckbox, DuplicateCheck_Add);
			elementUtil.isElementSelected(duplicateCheckApproveCheckbox, DuplicateCheck_Approve);
			elementUtil.isElementSelected(duplicateCheckModifyCheckbox, DuplicateCheck_Modify);
			elementUtil.isElementSelected(duplicateCheckDeleteCheckbox, DuplicateCheck_Delete);
			elementUtil.isElementSelected(duplicateCheckConfirmDeleteCheckbox, DuplicateCheck_ConfirmDelete);
			elementUtil.isElementSelected(representMappingListCheckbox, RepresentMapping_List);
			elementUtil.isElementSelected(representMappingAddCheckbox, RepresentMapping_Add);
			elementUtil.isElementSelected(representMappingApproveCheckbox, RepresentMapping_Approve);
			elementUtil.isElementSelected(representMappingModifyCheckbox, RepresentMapping_Modify);
			elementUtil.isElementSelected(representMappingDeleteCheckbox, RepresentMapping_Delete);
			elementUtil.isElementSelected(representMappingConfirmDeleteCheckbox, RepresentMapping_ConfirmDelete);
			elementUtil.isElementSelected(vendorListCheckbox, Vendor_List);
			elementUtil.isElementSelected(vendorAddCheckbox, Vendor_Add);
			elementUtil.isElementSelected(vendorApproveCheckbox, Vendor_Approve);
			elementUtil.isElementSelected(vendorModifyCheckbox, Vendor_Modify);
			elementUtil.isElementSelected(vendorDeleteCheckbox, Vendor_Delete);
			elementUtil.isElementSelected(vendorConfirmDeleteCheckbox, Vendor_ConfirmDelete);
			elementUtil.isElementSelected(vendorSchemeFormatCodeMappingCheckbox, Vendor_SchemeFormatCodeMapping);
			elementUtil.isElementSelected(chargeListCheckbox, Charge_List);
			elementUtil.isElementSelected(chargeAddCheckbox, Charge_Add);
			elementUtil.isElementSelected(chargeApproveCheckbox, Charge_Approve);
			elementUtil.isElementSelected(chargeModifyCheckbox, Charge_Modify);
			elementUtil.isElementSelected(chargeDeleteCheckbox, Charge_Delete);
			elementUtil.isElementSelected(chargeConfirmDeleteCheckbox, Charge_ConfirmDelete);
			elementUtil.isElementSelected(corporateChargePostingListCheckbox, CorporateChargePosting_List);
			elementUtil.isElementSelected(corporateChargePostingAddCheckbox, CorporateChargePosting_Add);
			elementUtil.isElementSelected(corporateChargePostingModifyCheckbox, CorporateChargePosting_Modify);
			elementUtil.isElementSelected(corporateChargePostingGenerateReportCheckbox, CorporateChargePosting_GenerateReport);
			elementUtil.isElementSelected(corporateChargePostingChargePostingCheckbox, CorporateChargePosting_ChargePosting);
			elementUtil.isElementSelected(ifscCodeListCheckbox, IFSCCODE_List);
			elementUtil.isElementSelected(ifscCodeAddCheckbox, IFSCCODE_Add);
			elementUtil.isElementSelected(ifscCodeApproveCheckbox, IFSCCODE_Approve);
			elementUtil.isElementSelected(ifscCodeModifyCheckbox, IFSCCODE_Modify);
			elementUtil.isElementSelected(ifscCodeDeleteCheckbox, IFSCCODE_Delete);
			elementUtil.isElementSelected(ifscCodeConfirmDeleteCheckbox, IFSCCODE_ConfirmDelete);
			elementUtil.isElementSelected(npciCodesMaintainNPCICodesCheckbox, NPCICodes_MaintainNPCICodes);
			elementUtil.isElementSelected(npciCodesListNPCICodesCheckbox, NPCICodes_ListNPCICodes);
			elementUtil.isElementSelected(dbLoadsCheckbox, DBLoads);
			elementUtil.isElementSelected(subMemberIFSCCODEUploadCheckbox, SubMemberIFSCCODE_Upload);
			elementUtil.isElementSelected(subMemberIFSCCODEListCheckbox, SubMemberIFSCCODE_List);
			elementUtil.isElementSelected(subMemberIFSCCODEAddCheckbox, SubMemberIFSCCODE_Add);
			elementUtil.isElementSelected(subMemberIFSCCODEApproveCheckbox, SubMemberIFSCCODE_Approve);
			elementUtil.isElementSelected(subMemberIFSCCODEModifyCheckbox, SubMemberIFSCCODE_Modify);
			elementUtil.isElementSelected(subMemberIFSCCODEDeleteCheckbox, SubMemberIFSCCODE_Delete);
			elementUtil.isElementSelected(subMemberIFSCCODEConfirmDeleteCheckbox, SubMemberIFSCCODE_ConfirmDelete);
			elementUtil.isElementSelected(parameterMaintenanceCheckbox, ParameterMaintenance);
			elementUtil.isElementSelected(distributionSetsListCheckbox, DistributionSets_List);
			elementUtil.isElementSelected(distributionSetsAddCheckbox, DistributionSets_Add);
			elementUtil.isElementSelected(distributionSetsApproveCheckbox, DistributionSets_Approve);
			elementUtil.isElementSelected(distributionSetsModifyCheckbox, DistributionSets_Modify);
			elementUtil.isElementSelected(distributionSetsDeleteCheckbox, DistributionSets_Delete);
			elementUtil.isElementSelected(messagesViewCheckbox, Messages_View);
			elementUtil.isElementSelected(messagesNewCheckbox, Messages_New);
			elementUtil.isElementSelected(scheduleListCheckbox, Schedule_List);
			elementUtil.isElementSelected(scheduleNewCheckbox, Schedule_New);
			elementUtil.isElementSelected(scheduleModifyCheckbox, Schedule_Modify);
			elementUtil.isElementSelected(scheduleControlCheckbox, Schedule_Control);
			elementUtil.isElementSelected(ftpsftpParametersListCheckbox, FTPSFTPParameters_List);
			elementUtil.isElementSelected(ftpsftpParametersAddCheckbox, FTPSFTPParameters_Add);
			elementUtil.isElementSelected(ftpsftpParametersModifyCheckbox, FTPSFTPParameters_Modify);
			elementUtil.isElementSelected(ftpsftpParametersFTPSFTPFileListCheckbox, FTPSFTPParameters_FTPSFTPFileList);
			elementUtil.isElementSelected(faqMaintainFAQCheckbox, FAQMaintainFAQ);
			elementUtil.isElementSelected(faqListFAQCheckbox, FAQListFAQ);
			elementUtil.isElementSelected(sessionMaintenanceListCheckbox, SessionMaintenance_List);
			elementUtil.isElementSelected(sessionMaintenanceAddCheckbox, SessionMaintenance_Add);
			elementUtil.isElementSelected(sessionMaintenanceModifyCheckbox, SessionMaintenance_Modify);
			elementUtil.isElementSelected(sessionMaintenanceDeleteCheckbox, SessionMaintenance_Delete);
			elementUtil.isElementSelected(nameMatchingListCheckbox, NameMatching_List);
			elementUtil.isElementSelected(nameMatchingAddCheckbox, NameMatching_Add);
			elementUtil.isElementSelected(nameMatchingModifyCheckbox, NameMatching_Modify);
			elementUtil.isElementSelected(nameMatchingDeleteCheckbox, NameMatching_Delete);
			elementUtil.isElementSelected(corporateListCheckbox, Corporate_List);
			elementUtil.isElementSelected(corporateAddCheckbox, Corporate_Add);
			elementUtil.isElementSelected(corporateModifyCheckbox, Corporate_Modify);
			elementUtil.isElementSelected(corporateDeleteCheckbox, Corporate_Delete);
			elementUtil.isElementSelected(freeFormatCodeListCheckbox, FreeFormatCode_List);
			elementUtil.isElementSelected(freeFormatCodeAddCheckbox, FreeFormatCode_Add);
			elementUtil.isElementSelected(freeFormatCodeCopyCheckbox, FreeFormatCode_Copy);
			elementUtil.isElementSelected(freeFormatCodeApproveCheckbox, FreeFormatCode_Approve);
			elementUtil.isElementSelected(freeFormatCodeModifyCheckbox, FreeFormatCode_Modify);
			elementUtil.isElementSelected(freeFormatCodeDeleteCheckbox, FreeFormatCode_Delete);
			elementUtil.isElementSelected(freeFormatCodeConfirmDeleteCheckbox, FreeFormatCode_ConfirmDelete);
			elementUtil.isElementSelected(fileManagerListCheckbox, FileManager_List);
			elementUtil.isElementSelected(fileManagerApprovePostingFileCheckbox, FileManager_ApprovePostingFile);
			elementUtil.isElementSelected(sponsorModuleCreateACHFileCheckbox, SponsorModule_CreateACHFile);
			elementUtil.isElementSelected(sponsorModuleAcceptCheckbox, SponsorModule_Accept);
			elementUtil.isElementSelected(sponsorModuleUploadCheckbox, SponsorModule_Upload);
			elementUtil.isElementSelected(sponsorModuleUploadAPBSFileCheckbox, SponsorModule_UploadAPBSFile);
			elementUtil.isElementSelected(sponsorModuleRejectFutureFileCheckbox, SponsorModule_RejectFutureFile);
			elementUtil.isElementSelected(sponsorModuleRepostCheckbox, SponsorModule_Repost);
			elementUtil.isElementSelected(sponsorModuleApprovePossibleRejectCheckbox, SponsorModule_ApprovePossibleReject);
			elementUtil.isElementSelected(sponsorModuleExportMisCheckbox, SponsorModule_ExportMis);
			elementUtil.isElementSelected(destinationModuleCreateReturnACHFileCheckbox, DestinationModule_CreateReturnACHFile);
			elementUtil.isElementSelected(destinationModuleUploadOldNewAccountMapperCheckbox, DestinationModule_UploadOldNewAccountMapper);
			elementUtil.isElementSelected(destinationModuleDebitInwardRepostCheckbox, DestinationModule_DebitInwardRepost);
			elementUtil.isElementSelected(destinationModuleCreditInwardRepostCheckbox, DestinationModule_CreditInwardRepost);
			elementUtil.isElementSelected(destinationModuleReffralDebitSentCheckbox, DestinationModule_ReffralDebitSent);
			elementUtil.isElementSelected(destinationModuleReffralCreditSentCheckbox, DestinationModule_ReffralCreditSent);
			elementUtil.isElementSelected(directDebitModuleListCheckbox, DirectDebitModule_List);
			elementUtil.isElementSelected(directDebitModuleUploadCheckbox, DirectDebitModule_Upload);
			elementUtil.isElementSelected(directDebitModuleCreateReturnACHFileCheckbox, DirectDebitModule_CreateReturnACHFile);
			elementUtil.isElementSelected(chargePostingListCheckbox, ChargePosting_List);
			elementUtil.isElementSelected(chargePostingCreateCheckbox, ChargePosting_Create);
			elementUtil.isElementSelected(chargePostingApproveCheckbox, ChargePosting_Approve);
			elementUtil.isElementSelected(chargeInvoiceChargeInvoiceCheckbox, ChargeInvoice_ChargeInvoice);
			elementUtil.isElementSelected(vendorChargeInvoiceCheckbox, VendorChargeInvoice);
			elementUtil.isElementSelected(nameMatchLibraryListCheckbox, NameMatchLibrary_List);
			elementUtil.isElementSelected(nameMatchLibraryApproveCheckbox, NameMatchLibrary_Approve);
			elementUtil.isElementSelected(nameMatchLibraryDeleteCheckbox, NameMatchLibrary_Delete);
			elementUtil.isElementSelected(paymentListCheckbox, Payment_List);
			elementUtil.isElementSelected(paymentApproveReturnCheckbox, Payment_ApproveReturn);
			elementUtil.isElementSelected(paymentVerifyReceivesCheckbox, Payment_VerifyReceives);
			elementUtil.isElementSelected(paymentOfflineUploadCheckbox, Payment_OfflineUpload);
			elementUtil.isElementSelected(paymentReferralReturnCheckbox, Payment_ReferralReturn);
			elementUtil.isElementSelected(paymentAPBManualCheckbox, Payment_APBManual);
			elementUtil.isElementSelected(paymentAPBManualConfirmCheckbox, Payment_APBManualConfirm);
			elementUtil.isElementSelected(fromUtilityLoadCustomerFileCheckbox, FromUtility_LoadCustomerFile);
			elementUtil.isElementSelected(fromUtilityInitialLoadCheckbox, FromUtility_InitialLoad);
			elementUtil.isElementSelected(fromUtilityMandateImageMappingCheckbox, FromUtility_MandateImageMapping);
			elementUtil.isElementSelected(sponsorMandateListMandatesCheckbox, SponsorMandate_ListMandates);
			elementUtil.isElementSelected(sponsorMandateApproveMandateCheckbox, SponsorMandate_ApproveMandate);
			elementUtil.isElementSelected(sponsorMandateCreateNewMandateCheckbox, SponsorMandate_CreateNewMandate);
			elementUtil.isElementSelected(sponsorMandateAmendMandateCheckbox, SponsorMandate_AmendMandate);
			elementUtil.isElementSelected(sponsorMandateCancelMandateCheckbox, SponsorMandate_CancelMandate);
			elementUtil.isElementSelected(sponsorMandateModifyMandateCheckbox, SponsorMandate_ModifyMandate);
			elementUtil.isElementSelected(sponsorMandateMandatesRegenerationCheckbox, SponsorMandate_MandatesRegeneration);
			elementUtil.isElementSelected(sponsorMandateMandateFileApproveCheckbox, SponsorMandate_MandateFileApprove);
			elementUtil.isElementSelected(sponsorMandateRejectMandateCheckbox, SponsorMandate_RejectMandate);
			elementUtil.isElementSelected(sponsorMandateAPIMismatchMandateListCheckbox, SponsorMandate_APIMismatchMandate_List);
			elementUtil.isElementSelected(sponsorMandateAPIMismatchMandateRetryCheckbox, SponsorMandate_APIMismatchMandate_Retry);
			elementUtil.isElementSelected(sponsorMandateAcceptRejectUnmatchedAPImandatesCheckbox, SponsorMandate_AcceptRejectUnmatchedAPImandates);
			elementUtil.isElementSelected(destinationMandateListMandatesCheckbox, DestinationMandate_ListMandates);
			elementUtil.isElementSelected(destinationMandateApproveMandateCheckbox, DestinationMandate_ApproveMandate);
			elementUtil.isElementSelected(destinationMandateAuthoriseMandateCheckbox, DestinationMandate_AuthoriseMandate);
			elementUtil.isElementSelected(destinationMandateAuthoriseTreasuryCheckbox, DestinationMandate_AuthoriseTreasury);
			elementUtil.isElementSelected(destinationMandateReleaseParkedMandatesCheckbox, DestinationMandate_ReleaseParkedMandate);
			elementUtil.isElementSelected(listMandatesCheckbox, ListMandates);
			elementUtil.isElementSelected(approveMandateCheckbox, ApproveMandate);
			elementUtil.isElementSelected(holdMandateHoldListCheckbox, HoldMandate_HoldList);
			elementUtil.isElementSelected(holdMandateAddModifyHoldCheckbox, HoldMandate_AddModifyHold);
			elementUtil.isElementSelected(holdMandateApproveHoldCheckbox, HoldMandate_ApproveHold);
			elementUtil.isElementSelected(holdMandateRemoveHoldCheckbox, HoldMandate_RemoveHold);
			elementUtil.isElementSelected(holdMandateConfirmHoldRemovalCheckbox, HoldMandate_ConfirmHoldRemoval);
			elementUtil.isElementSelected(uploadMoratoriumFileCheckbox, UploadMoratoriumFile);
			elementUtil.isElementSelected(serverFoldersServerFolderViewCheckbox, ServerFolders_ServerFolderView);
			elementUtil.isElementSelected(serverFoldersServerFolderCheckbox, ServerFolders_ServerFolder);
			elementUtil.isElementSelected(guideMandateFlowNPCICheckbox, GuideMandateFlowNPCI);
			elementUtil.isElementSelected(guideMandateInFlowCheckbox, GuideMandateInFlow);
			elementUtil.isElementSelected(guideMandateOutFlowCheckbox, GuideMandateOutFlow);
			elementUtil.isElementSelected(serverFolderViewCheckbox, ServerFolderView);
			elementUtil.isElementSelected(transactionsOutwardTransactionsCheckbox, Transactions_OutwardTransactions);
			elementUtil.isElementSelected(transactionsInwardTransactionsACHDebitCheckbox, Transactions_InwardTransactions_ACHDebit);
			elementUtil.isElementSelected(transactionsInwardTransactionsACHCreditCheckbox, Transactions_InwardTransactions_ACHCredit);
			elementUtil.isElementSelected(transactionsInwardTransactionsAPBCreditCheckbox, Transactions_InwardTransactions_APBCredit);
			elementUtil.isElementSelected(transactionsDashboardTechnologyCheckbox, Transactions_DashboardTechnology);
			elementUtil.isElementSelected(transactionsDDTransactionCheckbox, Transactions_DDTransaction);
			elementUtil.isElementSelected(mandatesMandateDashboardOverviewCheckbox, Mandates_MandateDashboardOverview);
			elementUtil.isElementSelected(mandatesMandateDashboardDailyCheckbox, Mandates_MandateDashboardDaily);
			elementUtil.isElementSelected(mandatesOutwardMandatesCheckbox, Mandates_OutwardMandates);
			elementUtil.isElementSelected(mandatesDDMandateDashboardOverviewCheckbox, Mandates_DDMandateDashboardOverview);
			elementUtil.isElementSelected(mandatesDDMandateDashboardDailyCheckbox, Mandates_DDMandateDashboardDaily);
			elementUtil.isElementSelected(mandatesInwardMandatesCheckbox, Mandates_InwardMandates);
			elementUtil.isElementSelected(mandateDashboardsVendorMandateDashboardCheckbox, MandateDashboards_VendorMandateDashboard);
			elementUtil.isElementSelected(cbdtCBDTDashboardCheckbox, CBDT_CBDTDashboard);
			elementUtil.isElementSelected(avAVDashboardCheckbox, AV_AVDashboard);
			elementUtil.isElementSelected(epfoEPFO_DashboardCheckbox, EPFO_EPFO_Dashboard);
			elementUtil.isElementSelected(reportEODReconciliationCheckbox, Report_EODReconciliation);
			elementUtil.isElementSelected(reportUserActivityCheckbox, Report_UserActivity);
			elementUtil.isElementSelected(reportPaymentsInwardCheckbox, Report_Payments_Inward);
			elementUtil.isElementSelected(reportPaymentsOutwardCheckbox, Report_Payments_Outward);
			elementUtil.isElementSelected(reportPaymentsTransactionreportCorpCheckbox, Report_Payments_TransactionreportCorp);
			elementUtil.isElementSelected(reportMandateInwardMandateCheckbox, Report_Mandate_InwardMandate);
			elementUtil.isElementSelected(reportMandateOutwardMandateCheckbox, Report_Mandate_OutwardMandate);
			elementUtil.isElementSelected(reportMandateMandateFileReportSchemesCheckbox, Report_Mandate_MandateFileReportSchemes);
			elementUtil.isElementSelected(reportMandateMandatereportCorpCheckbox, Report_Mandate_MandatereportCorp);
			elementUtil.isElementSelected(reportVendorVendorMandateReportCheckbox, Report_Vendor_VendorMandateReport);
			elementUtil.isElementSelected(reportVendorVendorTransactionReportCheckbox, Report_Vendor_VendorTransactionReport);
			elementUtil.isElementSelected(reportChargingReportBookingReportCheckbox, Report_ChargingReport_BookingReport);
			elementUtil.isElementSelected(reportChargingReportBillingInvoiceCheckbox, Report_ChargingReport_BillingInvoice);
			elementUtil.isElementSelected(reportProductivityMandateInwardMandateCheckbox, Report_Productivity_Mandate_InwardMandate);
			elementUtil.isElementSelected(reportProductivityMandateOutwardMandateCheckbox, Report_Productivity_Mandate_OutwardMandate);
			elementUtil.isElementSelected(reportSummaryCheckbox, Report_Summary);
			elementUtil.isElementSelected(reportAadharMapperCheckbox, Report_AadharMapper);
			elementUtil.isElementSelected(reportCBDTReportCBDTReportCheckbox, ReportCBDT_ReportCBDTReport);
			elementUtil.isElementSelected(reportReturnMemoCheckbox, Report_ReturnMemo);
			elementUtil.isElementSelected(applicationSupportToolsSpaceDumpCheckbox, ApplicationSupportTools_SpaceDump);
			elementUtil.isElementSelected(applicationSupportToolsSpaceRebuildCheckbox, ApplicationSupportTools_SpaceRebuild);
			elementUtil.isElementSelected(applicationSupportToolsWebServiceSimulatorCheckbox, ApplicationSupportTools_WebServiceSimulator);
			elementUtil.isElementSelected(applicationSupportToolsSystemInfoCheckbox, ApplicationSupportTools_SystemInfo);
			elementUtil.isElementSelected(applicationSupportToolsTraceFileLevelsCheckbox, ApplicationSupportTools_TraceFileLevels);
			elementUtil.isElementSelected(applicationSupportToolsDBExplorerCheckbox, ApplicationSupportTools_DBExplorer);
			elementUtil.isElementSelected(applicationSupportToolsLockManagementCheckbox, ApplicationSupportTools_LockManagement);
			elementUtil.isElementSelected(applicationSupportToolsLogExplorerCheckbox, ApplicationSupportTools_LogExplorer);
			elementUtil.isElementSelected(applicationSupportToolsParamConstantsCheckbox, ApplicationSupportTools_ParamConstants);
			elementUtil.isElementSelected(applicationSupportToolsBranchUnitAttributesListBranchDetailsCheckbox, ApplicationSupportTools_BranchUnitAttributes_ListBranchDetails);
			elementUtil.isElementSelected(applicationSupportToolsBranchUnitAttributesServerConnectionsCheckbox, ApplicationSupportTools_BranchUnitAttributes_ServerConnections);
			elementUtil.isElementSelected(applicationSupportToolsBranchUnitAttributesQueueManCheckbox, ApplicationSupportTools_BranchUnitAttributes_QueueMan);
			elementUtil.isElementSelected(applicationSupportToolsBranchUnitAttributesQueueMessageUploaderCheckbox, ApplicationSupportTools_BranchUnitAttributes_QueueMessageUploader);
			elementUtil.isElementSelected(applicationSupportToolsBranchUnitAttributesQueueMessageDownloaderCheckbox, ApplicationSupportTools_BranchUnitAttributes_QueueMessageDownloader);
			elementUtil.isElementSelected(applicationSupportToolsBranchUnitAttributesLogExplorerCheckbox, ApplicationSupportTools_BranchUnitAttributes_LogExplorer);
			elementUtil.isElementSelected(applicationSupportToolsUploadMandatesCheckbox, ApplicationSupportTools_UploadMandates);
			elementUtil.isElementSelected(applicationSupportToolsUploadAllMandatesCheckbox, ApplicationSupportTools_UploadAllMandates);
			elementUtil.isElementSelected(applicationSupportToolsMandateDirectDebitUploadCheckbox, ApplicationSupportTools_MandateDirectDebitUpload);
			
			elementUtil.clickElement(okBtn);
			elementUtil.SHORT_TIMEOUT();

			String profileNameErrorMessage = "Profile name is required.";
			String checkboxErrorMessage = "You must select some menu checkboxes";
			String ExistingMsg = "Profile already exists";
			
			try {
				if(elementUtil.getText(errormessages).equals(profileNameErrorMessage)){
					log.info("Validation message is displayed properly for Invalid Profile Name");
				}else if(elementUtil.getText(errormessages).equals(checkboxErrorMessage)){
					log.info("Validation message is displayed properly for Checkboxes");
				}else if(elementUtil.getText(errormessages).equals(ExistingMsg)){
					log.info("Duplicate Record Found. Record With Profile " +ProfileName+ " Already Exists");
				}else {
					log.error("Mandatory Fields Validation Message Displayed Is Incorrect");
					log.error("Test Data Provided For User Add Operation Is Not As Valid Format");
				}
			}catch (NoSuchElementException e) {
			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(okBtn);
			String profileAddValidationMessage="Operation Add new profile executed successfully. "+ProfileName+" placed in APPROVE queue.";
			if(elementUtil.getText(validationmsg).equals(profileAddValidationMessage))
			{
				log.info("Record With Profile Name "+ProfileName+" gets added and placed in Approve queue");
			}else {
				log.error("Record With Profile Name "+ProfileName+" failed to add");
			}
		}//end of catch
			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for
		//perform logout operation
		logOutOperation();
	}//end of profileAdd function

	// --------------Method to Remove Profile Record------------------------//
	public void profileRemove(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		test_Data = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String ProfileName = map.get("Profile name");

			//enter details on filter screen
			elementUtil.enterText(filterScreenProfileNameTxtField,ProfileName);

			//click on Reset Button
			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(filterScreenProfileNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine for Profile-->Remove screen");
			} else {
				log.error("Reset Button is not working for Profile-->Remove screen");
			}

			//enter details on filter screen
			elementUtil.enterText(filterScreenProfileNameTxtField,ProfileName);

			//click on ok button
			elementUtil.clickElement(okBtn);

			String CriteriaMsg = "No items available for Remove operation given the search criteria";
			String ValidationMsg="Operation Remove profile executed successfully. "+ProfileName+" placed in APPROVE queue.";
			
			if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
				{
					log.info("Record With " +ProfileName+ " Not Found For Remove Operation" );
				}
			else {
				if(elementUtil.getText(removeScreenProfileNameValue).trim().toString().equals(ProfileName))
				{
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(record);
					elementUtil.clickElement(btnRemove);
					if(elementUtil.getText(messages).equals(ValidationMsg))
					{
						log.info("Record With Profile "+ProfileName+" Removed Successfully and placed in Approve queue");
					}
				}//end of if
				else
				{
					log.error("Record Mismatch, Record With "+ProfileName+" Not Found For Remove Operation");
				}//end of else

			}//end of else
			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for

		// perform logout operation
		logOutOperation();
	}//end of profileRemove function

	// --------------Method to Approve Profile Record------------------------//
	public void profileApprove(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		test_Data = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String ProfileName = map.get("Profile name");
			String Operation=map.get("Operation");

			//enter details on filter screen
			elementUtil.enterText(filterScreenProfileNameTxtField,ProfileName);

			//click on Reset Button
			elementUtil.clickElement(btnReset);

			if (elementUtil.getText(filterScreenProfileNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine for Profile-->Approve Screen");
			} else {
				log.error("Reset Button is not working fine for Profile-->Approve Screen");
			}

			//enter details on filter screen
			elementUtil.enterText(filterScreenProfileNameTxtField,ProfileName);

			//click on ok button
			elementUtil.clickElement(okBtn);

			String CriteriaMsg = "No items available for Approve operation given the search criteria";
			String ValidationMsg = "Operation Approve profile changes failed to execute: User cannot approve own modification.";
			String ApprovalMsg = "Operation Approve profile changes executed successfully. "+ProfileName+" placed in active queue.";
			String RejectionMsg = "Operation Reject changes for profile executed successfully.";
			String RemoveMsg = "Operation Approve profile changes executed successfully. "+ProfileName+" placed in DELETED queue.";
			String ToRepairMsg = "Operation Send to repair executed successfully. "+ProfileName+" placed in REPAIR queue.";
			
			if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
				{
					log.info("Record With " +ProfileName+ " Not Found For Approve Operation" );
				} 
			else {
				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(record);
				elementUtil.SHORT_TIMEOUT();
				
				try {
				if(elementUtil.getText(errormessages).equals(ValidationMsg))
				{
					log.info("Approval of Record "+ProfileName+" Failed. User cannot approve own modification" );
				}
				}catch (NoSuchElementException e) {
					switch (Operation) {
						case "Approve":
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(approveBtn);
							break;

						case "Reject":
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(rejectBtn);
							break;
					
						case "To Repair":
							elementUtil.SHORT_TIMEOUT();
							elementUtil.clickElement(toRepairBtn);
							break;
					}
				
					if(elementUtil.getText(validationmsg).equals(ApprovalMsg))
					{
						log.info("Record With Profile "+ProfileName+" Approved Successfully");
					} else if(elementUtil.getText(validationmsg).contains(RejectionMsg))
					{
						log.info("Record With Values "+ProfileName+" Rejected Successfully" );
					}else if(elementUtil.getText(validationmsg).equals(ToRepairMsg))
					{
						log.info("Record With Values "+ProfileName+" Sent To Repair Queue Successfully" );
					}else if(elementUtil.getText(validationmsg).equals(RemoveMsg)){
						log.info("Record With Values "+ProfileName+" removed Successfully" );
					}else {
						log.info("Profile "+ProfileName+" is failed to "+Operation+"");
					}
				}//end of catch
			}
			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for
		// perform logout operation
		logOutOperation();
	}//end of profileApprove function


	//--------------Method to List Profile Record------------------------//
	public void listProfileRecord(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		test_Data = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String ProfileName = map.get("Profile name");
			String Status=map.get("With status");

			//enter details on filter screen
			elementUtil.sendkeys(filterScreenProfileNameTxtField, ProfileName);
			elementUtil.selectDropDownByVisibleText(statusDropdown, Status);

			elementUtil.clickElement(btnReset);

			if (elementUtil.getAttribute(filterScreenProfileNameTxtField).isEmpty()) {
				log.info("Reset Button is working fine for Profile-->List screen");
			} else {
				log.error("Reset Button is not working for Profile-->List screen");
			}

			//enter details on filter screen
			elementUtil.sendkeys(filterScreenProfileNameTxtField, ProfileName);
			elementUtil.selectDropDownByVisibleText(statusDropdown, Status);

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(okBtn);
			
			String CriteriaMsg = "No items available for List operation given the search criteria";

			if(elementUtil.getText(validateFilterMsg).equals(CriteriaMsg))
				{
					log.info("Record With " +ProfileName+ " Not Found For List Operation" );
				}//end of if
			else {
				elementUtil.SHORT_TIMEOUT();
				String profileRecordStatusValue=elementUtil.getText(listScreenProfileStatus);
				System.out.println("profileRecordStatusValue " +profileRecordStatusValue);
				elementUtil.SHORT_TIMEOUT();
				String listScreenRecordProfileNameValue=elementUtil.getText(listScreenProfileNameValue);
				System.out.println("listScreenRecordProfileNameValue " +listScreenRecordProfileNameValue);
				elementUtil.SHORT_TIMEOUT();
				if(listScreenRecordProfileNameValue.trim().toString().equals(ProfileName.trim().toString()))
				{
					log.info("Record "+ProfileName+" Is Displayed In List With Status "+profileRecordStatusValue);
				}//end of if
				else
				{
					log.info("Record "+ProfileName+" Is Not Displayed In List" );

				}//end of else
			}//end of else

			elementUtil.clickElement(restartWorkFlowBtn);
		}//end of for 
		// perform logout operation
		logOutOperation();
	}//end of listProfileRecord function

	//--------------Method to Modify/Repair Profile Record------------------------//
	public void modifyRepairprofile(String SheetName) throws InterruptedException, InvalidFormatException, IOException {
		test_Data = fileReader.readSetupExcel(SheetName);
		for (Map<String, String> map : test_Data) {
			String originalProfileName = map.get("Original Profile Name");
			String ProfileName=map.get("Profile Name");
			String ProfileDescription = map.get("Profile Description");

			elementUtil.SHORT_TIMEOUT();
			elementUtil.clickElement(restartWorkFlowBtn);

			elementUtil.enterText(filterScreenProfileNameTxtField, originalProfileName);
			elementUtil.clickElement(btnReset);

			if(elementUtil.getText(filterScreenProfileNameTxtField).isEmpty())
			{
				log.info("Reset Button Is Working Fine");
			}//end
			else
			{
				log.error("Reset Button Not Working Fine");
			}//end of else

			elementUtil.enterText(filterScreenProfileNameTxtField, originalProfileName);
			elementUtil.clickElement(okBtn);

			try {
				if(elementUtil.getText(errormessages).trim().toString().equals("No items available for Modify/Repair profile operation".trim().toString()))
				{
					log.info("Record With Profile " +originalProfileName+ " Not Found For Modify Operation");
				}
			} catch (NoSuchElementException e) {

				elementUtil.SHORT_TIMEOUT();
				elementUtil.clickElement(modifyRecord);
				if(elementUtil.getAttribute(profileNameTxtField).trim().toString().equals(originalProfileName))	
				{
					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(btnCancel);

					String ActualCancelBtnValidationMsg = elementUtil.getText(errormessages);
					String ExpectedCancelBtnValidationMsg = "Operation Modify/Repair profile was cancelled.";

					if (ActualCancelBtnValidationMsg.trim().toString().equals(ExpectedCancelBtnValidationMsg.trim().toString())) {
						log.info("Cancel button is working fine");
					} else {
						log.error("Cancel button is not working");
					}	

					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(restartWorkFlowBtn);

					elementUtil.enterText(filterScreenProfileNameTxtField, originalProfileName);
					elementUtil.clickElement(okBtn);

					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(modifyRecord);

					elementUtil.clearText(profileNameTxtField);
					elementUtil.clearText(profileDescTxtField);
					elementUtil.clickElement(btnUnChkAll);

					elementUtil.SHORT_TIMEOUT();
					elementUtil.clickElement(okBtn);

					String profileModifyScreenErrorMessageexpected="Profile Name is required." + "You must select some menu checkboxes";

					if (elementUtil.getText(errormessages).trim().toString().equals(profileModifyScreenErrorMessageexpected.trim().toString())) {
						log.info("Mandatory Fields Validation Message For Profile Modify/Repair Screen Displayed Is Correct");
					} else {
						log.info("Mandatory Fields Validation Message For Profile Modify/Repair Screen Displayed Is Incorrect");
					}

					elementUtil.SHORT_TIMEOUT();
					elementUtil.enterText(profileNameTxtField, ProfileName);
					elementUtil.enterText(profileDescTxtField, ProfileDescription);
					elementUtil.clickElement(btnChkAll);
//					elementUtil.clickElement(btnOk);

					try {

						if(elementUtil.getText(errormessages).trim().toString().equals("Profile already exists".trim().toString()))
						{
							log.info("Duplicate Record Found Record With Profile " +ProfileName+ " Already Exists");
						}//end of if
						else
						{
							log.error("Test Data Provided For Profile Modify Operation Is Not As Valid Format");
						}//end of else
					} catch (NoSuchElementException e2) {
						elementUtil.clickElement(okBtn);
						String profileAddValidationMessage="Operation Modify/Repair profile executed successfully. " +ProfileName+ "  placed in Approve queue. ";
						if(elementUtil.getText(messages).trim().toString().equals(profileAddValidationMessage.trim().toString()))
						{
							log.info("Record With Profile Name " +ProfileName+ " Modified Successfully");
						}
					}//end of catch

				}//end of if
				else
				{
					log.error("Record Mismatch, Record With Profile Name " +originalProfileName+ " Not Found For Modify Operation");
				}
			}//end of catch 
		}//end of for

		//perform logout operation
		elementUtil.SHORT_TIMEOUT();
		elementUtil.handlewin1(driver);
		logOutOperation();
	}//end of modifyRepairProfile function

	//-----------------Method to perform Logout Operation----------------------------
	public void logOutOperation() throws InterruptedException {
		elementUtil.clickElement(logOutBtn);
		elementUtil.clickElement(logoutBtn);
		elementUtil.quitBrowser();
	}// end of logOutOperation function



}
