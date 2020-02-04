package ca.bc.gov.educ.api.servicescard.validator;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ca.bc.gov.educ.api.servicescard.repository.ServicesCardRepository;
import ca.bc.gov.educ.api.servicescard.service.ServicesCardService;

@RunWith(MockitoJUnitRunner.class)
public class ServicesCardPayloadValidatorTest {
  private boolean isCreateOperation = false;
  @Mock
  ServicesCardRepository repository;
  @Mock
  ServicesCardService servicesCardService;
  @InjectMocks
  ServicesCardPayloadValidator servicesCardPayloadValidator;

  @Before
  public void before() {
	servicesCardService = new ServicesCardService(repository);
    servicesCardPayloadValidator = new ServicesCardPayloadValidator(servicesCardService);
  }

//  @Test
//  public void testValidatePEN_WhenPENNumberInThePayloadIsAlreadyAssociatedToDifferentStudentForInsertOperation_ShouldAddAnErrorTOTheReturnedList() {
//    isCreateOperation = true;
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(repository.findStudentEntityByPen(pen)).thenReturn(createDummyStudentRecordForInsertOperation(pen));
//    servicesCardPayloadValidator.validatePEN(Student.builder().pen(pen).build(), isCreateOperation, errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidatePEN_WhenPENNumberInThePayloadIsNotAssociatedToDifferentStudentForInsertOperation_ShouldNotAddAnErrorTOTheReturnedList() {
//    isCreateOperation = true;
//    final String pen = "123456780";
//    List<FieldError> errorList = new ArrayList<>();
//    createDummyStudentRecordForInsertOperation(pen);
//    when(repository.findStudentEntityByPen(pen)).thenReturn(Optional.empty());
//    servicesCardPayloadValidator.validatePEN(Student.builder().pen(pen).build(), isCreateOperation, errorList);
//    assertEquals(0, errorList.size());
//  }
//
//  @Test
//  public void testValidatePEN_WhenPENNumberInThePayloadIsAssociatedToDifferentStudentForUpdateOperation_ShouldAddAnErrorTOTheReturnedList() {
//    isCreateOperation = false;
//    final String pen = "123456780";
//    List<FieldError> errorList = new ArrayList<>();
//    when(repository.findStudentEntityByPen(pen)).thenReturn(createDummyStudentRecordForUpdateOperation(pen));
//    servicesCardPayloadValidator.validatePEN(Student.builder().pen(pen).studentID("8e20a9c8-6ff3-12bf-816f-f3b2d4f20001").build(), isCreateOperation, errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidatePEN_WhenPENNumberInThePayloadIsAssociatedToSameStudentForUpdateOperation_ShouldNotAddAnErrorTOTheReturnedList() {
//    isCreateOperation = false;
//    final String pen = "123456780";
//    List<FieldError> errorList = new ArrayList<>();
//    when(repository.findStudentEntityByPen(pen)).thenReturn(createDummyStudentRecordForUpdateOperation(pen));
//    servicesCardPayloadValidator.validatePEN(Student.builder().pen(pen).studentID("8e20a9c8-6ff3-12bf-816f-f3b2d4f20000").build(), isCreateOperation, errorList);
//    assertEquals(0, errorList.size());
//  }
//
//  @Test
//  public void testValidateGenderCode_WhenGenderCodeDoesNotExistInCodeTable_ShouldAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(codeTableService.findGenderCode("M")).thenReturn(null);
//    servicesCardPayloadValidator.validateGenderCode(Student.builder().genderCode("M").pen(pen).build(), errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidateGenderCode_WhenGenderCodeExistInCodeTableButEffectiveDateIsFutureDate_ShouldAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    GenderCode code = dummyGenderCode();
//    code.setEffectiveDate(new GregorianCalendar(2099, Calendar.FEBRUARY, 1).getTime());
//    code.setGenderCode("M");
//    when(codeTableService.findGenderCode("M")).thenReturn(code);
//    servicesCardPayloadValidator.validateGenderCode(Student.builder().genderCode("M").pen(pen).build(), errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidateGenderCode_WhenGenderCodeExistInCodeTableButExpiryDateIsPast_ShouldAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    GenderCode code = dummyGenderCode();
//    code.setExpiryDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
//    code.setGenderCode("M");
//    when(codeTableService.findGenderCode("M")).thenReturn(code);
//    servicesCardPayloadValidator.validateGenderCode(Student.builder().genderCode("M").pen(pen).build(), errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidateGenderCode_WhenGenderCodeExistAndValid_ShouldNotAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(codeTableService.findGenderCode("M")).thenReturn(dummyGenderCode());
//    servicesCardPayloadValidator.validateGenderCode(Student.builder().genderCode("M").pen(pen).build(), errorList);
//    assertEquals(0, errorList.size());
//  }
//
//  @Test
//  public void testValidateDataSourceCode_WhenDataSourceCodeDoesNotExistInCodeTable_ShouldAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(codeTableService.findDataSourceCode("MY_ED1")).thenReturn(null);
//    servicesCardPayloadValidator.validateDataSourceCode(Student.builder().genderCode("M").dataSourceCode("MY_ED1").pen(pen).build(), errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidateDataSourceCode_WhenDataSourceCodeExistInCodeTableAndValid_ShouldNotAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(codeTableService.findDataSourceCode("MY_ED1")).thenReturn(createDummyDataSource("MY_ED1"));
//    servicesCardPayloadValidator.validateDataSourceCode(Student.builder().genderCode("M").dataSourceCode("MY_ED1").pen(pen).build(), errorList);
//    assertEquals(0, errorList.size());
//  }
//
//  @Test
//  public void testValidateDataSourceCode_WhenDataSourceCodeExistInCodeTableAndExpired_ShouldAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    DataSourceCode code = createDummyDataSource("MY_ED");
//    code.setExpiryDate(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
//    when(codeTableService.findDataSourceCode("MY_ED")).thenReturn(code);
//    servicesCardPayloadValidator.validateDataSourceCode(Student.builder().genderCode("M").dataSourceCode("MY_ED").pen(pen).build(), errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidateDataSourceCode_WhenDataSourceCodeExistInCodeTableAndNotYetEffective_ShouldAddAnErrorTOTheReturnedList() {
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    DataSourceCode code = createDummyDataSource("MY_ED");
//    code.setEffectiveDate(new GregorianCalendar(2099, Calendar.JANUARY, 1).getTime());
//    when(codeTableService.findDataSourceCode("MY_ED")).thenReturn(code);
//    servicesCardPayloadValidator.validateDataSourceCode(Student.builder().genderCode("M").dataSourceCode("MY_ED").pen(pen).build(), errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidateEmail_WhenEmailIsAssociatedToAnotherStudent_ShouldAddAnErrorTOTheReturnedList() {
//    isCreateOperation = true;
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(repository.findStudentEntityByEmail("abc@gmail.com")).thenReturn(createDummyStudentRecordForInsertOperation(pen));
//    servicesCardPayloadValidator.validateEmail(Student.builder().email("abc@gmail.com").genderCode("M").dataSourceCode("MY_ED").pen(pen).build(), isCreateOperation, errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidateEmail_WhenEmailIsNotAssociatedToAnotherStudent_ShouldNotAddAnErrorTOTheReturnedList() {
//    isCreateOperation = true;
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(repository.findStudentEntityByEmail("abc@gmail.com")).thenReturn(Optional.empty());
//    servicesCardPayloadValidator.validateEmail(Student.builder().email("abc@gmail.com").genderCode("M").dataSourceCode("MY_ED").pen(pen).build(), isCreateOperation, errorList);
//    assertEquals(0, errorList.size());
//  }
//
//  @Test
//  public void testValidateEmail_WhenEmailIsAssociatedToAnotherStudentDuringUpdate_ShouldAddAnErrorTOTheReturnedList() {
//    isCreateOperation = false;
//    final String pen = "123456789";
//    List<FieldError> errorList = new ArrayList<>();
//    when(repository.findStudentEntityByEmail("abc@gmail.com")).thenReturn(createDummyStudentRecordForUpdateOperation(pen));
//    servicesCardPayloadValidator.validateEmail(Student.builder().studentID("8e20a9c8-6ff3-12bf-816f-f3b2d4f20001").email("abc@gmail.com").genderCode("M").dataSourceCode("MY_ED").pen(pen).build(), isCreateOperation, errorList);
//    assertEquals(1, errorList.size());
//  }
//
//  @Test
//  public void testValidatePayload_WhenAllTheFieldsAreInvalidForCreate_ShouldAddAllTheErrorsTOTheReturnedList() {
//    isCreateOperation = true;
//    final String pen = "123456789";
//    when(repository.findStudentEntityByEmail("abc@gmail.com")).thenReturn(createDummyStudentRecordForInsertOperation(pen));
//    when(codeTableService.findDataSourceCode("MY_ED")).thenReturn(null);
//    when(codeTableService.findGenderCode("M")).thenReturn(null);
//    when(repository.findStudentEntityByPen(pen)).thenReturn(createDummyStudentRecordForInsertOperation(pen));
//    List<FieldError> errorList = servicesCardPayloadValidator.validatePayload(Student.builder().studentID("8e20a9c8-6ff3-12bf-816f-f3b2d4f20001").email("abc@gmail.com").genderCode("M").dataSourceCode("MY_ED").pen(pen).build(), isCreateOperation);
//    assertEquals(4, errorList.size());
//  }



}
