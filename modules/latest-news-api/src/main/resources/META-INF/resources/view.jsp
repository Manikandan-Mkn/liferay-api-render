<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:resourceURL var="fetchNewsURL">
    <portlet:param name="cmd" value="fetchNews"/>
</portlet:resourceURL>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .card-img-top {
            max-width: 100%;
            height: 250px;
            object-fit: cover;
        }
        .card {
            border: 1px solid #ddd;
            margin-bottom: 20px;
        }
        .card-body {
            padding: 15px;
        }
        .card-title {
            font-size: 1.1rem;
            font-weight: bold;
        }
        .card-text {
            font-size: 0.9rem;
            color: #333;
        }
    </style>
</head>

<body>
    <div class="container mt-5">
        <h1 class="text-center mb-4">Top News</h1>
        <div id="news-container" class="row">
            <!-- News articles will be dynamically loaded here -->
        </div>
        <p id="no-news-message" class="text-center" style="display: none;">No news available.</p>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <script>
        $(document).ready(function () {
            const newsContainer = $('#news-container');
            const noNewsMessage = $('#no-news-message');
            const fetchNewsURL = '${fetchNewsURL}';

            console.log('Fetching news from:', fetchNewsURL);

            $.ajax({
                url: fetchNewsURL,
                type: 'GET',
                dataType: 'json',
                success: function(response) {
                    console.log('Fetched data:', response);  // Log the data to verify it's coming through

                    const articles = response || [];

                    if (articles.length === 0) {
                        noNewsMessage.show();  // Show "No news available" if no articles
                        return;
                    }

                    noNewsMessage.hide();  // Hide "No news available" if articles exist

                    let html = '';
                    articles.forEach(function(article) {
                        const imageHtml = article.urlToImage 
                            ? `<img src="${article.urlToImage}" class="card-img-top" alt="${article.title}">`
                            : '<img src="https://via.placeholder.com/500x250" class="card-img-top" alt="No Image Available">'; // Default image if no image

                        const publishedDate = article.publishedAt ? new Date(article.publishedAt).toLocaleDateString() : 'Unknown Date';  // Format the date
                        const author = article.author || 'Unknown Author';  // Handle missing author
                        const description = article.description || 'No description available.';  // Handle missing description
                        const title = article.title || 'Untitled';  // Handle missing title
                        const url = article.url || '#';  // Handle missing URL

                        // Generate the HTML for each article card
                        html += `
                            <div class="col-md-4 mb-4">
                                <div class="card">
                                    ${imageHtml}
                                    <div class="card-body">
                                        <h5 class="card-title">${title}</h5>
                                        <p class="card-text">${description}</p>
                                        <p class="card-text"><small class="text-muted">By ${author} | Published on: ${publishedDate}</small></p>
                                        <a href="${url}" target="_blank" class="btn btn-primary">Read more</a>
                                    </div>
                                </div>
                            </div>
                        `;
                    });

                    newsContainer.html(html);  // Insert the articles into the container
                },
                error: function(xhr, status, error) {
                    console.log('Error fetching news:', error);
                    newsContainer.html('<p class="text-danger">Failed to load news. Please try again later.</p>');
                    noNewsMessage.hide();  // Hide the fallback message on error
                }
            });
        });
    </script>
</body>
