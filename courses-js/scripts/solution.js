const coursesNames = {
    fundamentals: 'Java Fundamentals',
    advanced: 'Java Advanced',
    db: 'Java DB',
    web: 'Java Web',
    htmlAndCss: 'HTML & CSS',
};

const educationFormNames = {
    online: 'Online',
    onSite: 'On Site',
};

const availableCourses = [
    { name: coursesNames.fundamentals, price: 170 },
    { name: coursesNames.advanced, price: 180 },
    { name: coursesNames.db, price: 190 },
    { name: coursesNames.web, price: 490 },
];

const educationForms = [
    { name: educationFormNames.onSite, discount: 0 },
    { name: educationFormNames.online, discount: 0.06 },
];

const getCourseItem = (course) => {
    const input = $('<input/>')
        .attr('type', 'checkbox')
        .val(course.name);
    return $('<label/>')
        .append(input)
        .append(course.name);
};

const getEducationFormItem = (educationForm) => {
    const input = $('<input/>')
        .attr('type', 'radio')
        .attr('name', 'education-forms')
        .val(educationForm.name);
    return $('<label/>')
        .append(educationForm.name)
        .append(input);
};
const getMyCourseItem = (course) => course.name;

const generateList = (items, generateItemFunc) =>
    items
        .map(item => generateItemFunc(item))
        .map(itemElement => $('<li/>').append(itemElement));

const generateAvailableCoursesList = () => {
    const items = generateList(availableCourses, getCourseItem);
    items.forEach(item => item.appendTo('#list-courses'));
};

const generateMyCoursesList = (courses) => {
    const items = generateList(courses, getMyCourseItem);
    $('#list-my-courses').html('');
    items.forEach(item => item.appendTo('#list-my-courses'));
};

const generateEducationFormsList = () => {
    const items = generateList(educationForms, getEducationFormItem);
    items.forEach(item => item.appendTo('#list-education-forms'));
    $('#list-education-forms li:first-of-type input')
        .attr('checked', 'checked');
};

const getSelectedCourses = () => {
    const courseNames = Array.from($('#list-courses input:checked'))
        .map(input => $(input).val());
    return courseNames
        .map(courseName =>
           ({...availableCourses.find(course => course.name === courseName)}))
};

const getSelectedEducationForm = () => {
    const educationFormName = $('#list-education-forms input:checked').val();
    return educationForms.find(educationForm =>
        educationForm.name === educationFormName);
};

const getCourse = (courses, courseName) =>
    courses.find(course => course.name === courseName);

const decorateCourses = (courses) => {
    const fundametalsCourse = getCourse(courses, coursesNames.fundamentals);
    const advancedCourse = getCourse(courses, coursesNames.advanced);
    const dbCourse = getCourse(courses, coursesNames.db);
    const webCourse = getCourse(courses, coursesNames.web);
    if (fundametalsCourse && advancedCourse) {
        // discount 10%
        advancedCourse.price *= 0.9;
        if (dbCourse) {
            // discount 6%
            fundametalsCourse.price *= 0.94;
            advancedCourse.price *= 0.94;
            dbCourse.price *= 0.94;
            if (webCourse) {
                courses.push({
                    name: coursesNames.htmlAndCss,
                    price: 0,
                });
            }
        }
    }
};

const onSignMeUpClick = () => {
    const courses = getSelectedCourses();
    const educationForm = getSelectedEducationForm();
    decorateCourses(courses);
    let totalPrice = courses.reduce(
        (sum, course) => sum + course.price,
        0);
    if(educationForm.name === educationFormNames.online) {
        // discount 6%
        totalPrice *= 0.94;
    }

    $('#total-price').html(totalPrice.toFixed(2));
    generateMyCoursesList(courses);
};

$(function () {
    generateAvailableCoursesList();
    generateEducationFormsList();

    $('#btn-sign-me-up')
        .on('click', onSignMeUpClick);

    $('#list-my-courses').on('click', 'li', function() {
        $(this).remove();
    });
});