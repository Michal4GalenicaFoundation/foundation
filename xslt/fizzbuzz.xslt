<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:output method="text"/>

<xsl:template match="*">
	<xsl:apply-templates select="*"/>	
</xsl:template>

<xsl:template match="//element">
	<xsl:variable name="index" select="position()"/>
	<xsl:choose>
		<xsl:when test="$index mod 15 = 0">fizzbuzz</xsl:when>
		<xsl:when test="$index mod 5 = 0">buzz</xsl:when>
		<xsl:when test="$index mod 3 = 0">fizz</xsl:when>
 		<xsl:otherwise><xsl:value-of select="$index"/></xsl:otherwise> 
	</xsl:choose>
	<xsl:text> </xsl:text>
</xsl:template>


</xsl:stylesheet>
