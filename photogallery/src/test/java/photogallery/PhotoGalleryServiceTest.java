package photogallery;

import java.util.List;

import junit.framework.TestCase;

public class PhotoGalleryServiceTest extends TestCase {
    public void testAdd() {
        Article article = new Article();
        article.setWriter("kenu");
        article.setTitle("title");
        article.setContent("content");

        PhotoGalleryService photoGalleryService = new PhotoGalleryService();
        int add = photoGalleryService.add(article);
        assertTrue(add > 0);
    }

    public void testGet() {
        Article article = new Article();
        article.setWriter("kenu");
        article.setTitle("title");
        article.setContent("content");

        PhotoGalleryService photoGalleryService = new PhotoGalleryService();
        int add = photoGalleryService.add(article);
        assertTrue(add > 0);

        Article article2 = photoGalleryService.get(add);
        assertEquals(article.getWriter(), article2.getWriter());

    }

    public void testDelete() {
        Article article = new Article();
        article.setWriter("kenu");
        article.setTitle("title");
        article.setContent("content");

        PhotoGalleryService photoGalleryService = new PhotoGalleryService();
        int add = photoGalleryService.add(article);

        long sizeBefore = photoGalleryService.size();
        boolean result = photoGalleryService.delete(add);
        assertTrue(result);
        long sizeAfter = photoGalleryService.size();
        assertEquals(1, sizeBefore - sizeAfter);
    }

    public void testUpdate() {
        Article article = new Article();
        article.setId(1L);
        article.setWriter("kenu");
        article.setTitle("title");
        article.setContent("content");

        PhotoGalleryService photoGalleryService = new PhotoGalleryService();
        int add = photoGalleryService.add(article);
        assertTrue(add > 0);

        Article article2 = photoGalleryService.get(add);
        article2.setContent("content changed");
        photoGalleryService.update(article2);

        Article article3 = photoGalleryService.get(add);
        assertNotSame(article2, article3);
        assertEquals("content changed", article3.getContent());

    }

    public void testGetList() {
        Article article = new Article();
        article.setWriter("kenu");
        article.setTitle("title");
        article.setContent("content");

        Article article2 = new Article();
        article2.setWriter("kenu2");
        article2.setTitle("title2");
        article2.setContent("content2");

        PhotoGalleryService photoGalleryService = new PhotoGalleryService();
        int before = photoGalleryService.getList().size();
        int add = photoGalleryService.add(article);
        assertTrue(add > 0);
        int add1 = photoGalleryService.add(article2);
        assertTrue(add1 > 0);

        List<Article> list = photoGalleryService.getList();
        int size = list.size();
        assertEquals(2, size - before);

    }

}
